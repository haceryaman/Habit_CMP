package com.baitent.habit_compose.presentation.features.sign_in

import androidx.lifecycle.ViewModel
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.Firebase


class SignInViewModel : ViewModel(),
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
            SignInContract.UiAction.OnSignInClick -> performEmailSignIn()
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

    private suspend fun performEmailSignIn() {
        updateUiState { copy(isLoading = true) }

        try {
            auth.signInWithEmailAndPassword(uiState.value.email, uiState.value.password)
            updateUiState { copy(isLoading = false) }
            emitUiEffect(SignInContract.UiEffect.NavigateHome)

        } catch (e: Exception) {
            val msg = when {
                e.message?.contains("There is no user record") == true ||
                        e.message?.contains("user-not-found", ignoreCase = true) == true ->
                    "Böyle bir kullanıcı bulunamadı"
                e.message?.contains("The password is invalid", ignoreCase = true) == true ||
                        e.message?.contains("wrong-password", ignoreCase = true) == true ->
                    "Şifre yanlış"
                else ->
                    e.message ?: "Bilinmeyen bir hata oluştu"
            }
            updateUiState {
                copy(isLoading = false, errorMessage = msg)
            }
        }
    }

    private fun SignInContract.UiState.enableButtonIfValid(): SignInContract.UiState {
        val enabled = email.isNotBlank() && password.length >= 6
        return copy(isButtonEnabled = enabled)
    }
}
