package com.baitent.habit_compose.presentation.features.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baitent.habit_compose.data.models.UserEntity
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import com.baitent.habit_compose.domain.repository.AuthRepository
import com.baitent.habit_compose.domain.repository.UserRepository
import com.baitent.habit_compose.navigation.Screen
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.Firebase
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authRepo: AuthRepository,
    private val userRepo: UserRepository,
) : ViewModel(),
    MVI<SignInContract.UiState, SignInContract.UiAction, SignInContract.UiEffect>
    by mvi(SignInContract.UiState()) {

    private val auth: FirebaseAuth = Firebase.auth

    override suspend fun onAction(uiAction: SignInContract.UiAction) {
        when (uiAction) {
            is SignInContract.UiAction.OnEmailChanged -> updateUiState {
                copy(email = uiAction.email).enableButtonIfValid()
            }

            is SignInContract.UiAction.OnPasswordChanged -> updateUiState {
                copy(password = uiAction.password).enableButtonIfValid()
            }

            is SignInContract.UiAction.OnRememberMeToggled -> updateUiState {
                copy(isRememberMe = uiAction.remember)
            }

            SignInContract.UiAction.OnForgotPasswordClick -> handleForgotPassword()

            SignInContract.UiAction.OnSignInClick -> onSignIn(
                uiState.value.email,
                uiState.value.password,
                uiState.value.isRememberMe
            )

            SignInContract.UiAction.OnGoogleSignInClick -> {
                // TODO: Google Sign-In flow’u ekle
                emitUiEffect(SignInContract.UiEffect.NavigateHome)
            }

            SignInContract.UiAction.OnSignUpClick -> {
                emitUiEffect(SignInContract.UiEffect.NavigateSignUp)
            }

            SignInContract.UiAction.OnDialogDismiss -> updateUiState {
                copy(errorMessage = null)
            }
        }
    }

    private suspend fun handleForgotPassword() {
        val email = uiState.value.email
        if (email.isBlank()) {
            emitUiEffect(SignInContract.UiEffect.ShowSnackbar("Lütfen önce e-postanızı girin"))
        } else {
            try {
                auth.sendPasswordResetEmail(email)
                emitUiEffect(SignInContract.UiEffect.ShowSnackbar("Şifre sıfırlama e-postası gönderildi"))
            } catch (e: Exception) {
                emitUiEffect(
                    SignInContract.UiEffect.ShowSnackbar(
                        e.message ?: "Şifre sıfırlama başarısız oldu"
                    )
                )
            }
        }
    }

    private fun onSignIn(
        email: String,
        password: String,
        rememberMeChecked: Boolean
    ) {
        viewModelScope.launch {
            authRepo.signIn(email, password).collect { result ->
                result.onSuccess { firebaseUser ->
                    val userEntity = UserEntity(
                        email = firebaseUser.email.orEmpty(),
                        userName = firebaseUser.displayName,
                        firstName = null,
                        lastName = null,
                        avatarUrl = "firebaseUser.photoUrl?.toString()",
                        isRememberMe = rememberMeChecked
                    )
                    userRepo.save(userEntity)

                    emitUiEffect(SignInContract.UiEffect.NavigateHome)
                }.onFailure { exception ->
                    emitUiEffect(
                        SignInContract.UiEffect.ShowSnackbar(
                            exception.message ?: "Giriş sırasında bir hata oluştu"
                        )
                    )
                }
            }
        }
    }
    /** Uygulama açılırken çağrılabilir: */
    suspend fun decideStartDestination(): Screen =
        if (userRepo.getRemembered() != null) Screen.Main
        else Screen.Welcome

    private fun SignInContract.UiState.enableButtonIfValid(): SignInContract.UiState {
        val enabled = email.isNotBlank() && password.length >= 6
        return copy(isButtonEnabled = enabled)
    }
}