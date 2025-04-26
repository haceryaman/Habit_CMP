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

    init {
        // Önceden kaydedilmiş e-postayı yükle
        /*val saved = prefs.getString("saved_email", "") ?: ""
        if (saved.isNotBlank()) {
            updateUiState {
                copy(
                    email = saved,
                    isRememberMe = true
                ).enableButtonIfValid()
            }
        }*/
    }

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

    private suspend fun performEmailSignIn() {
        updateUiState { copy(isLoading = true) }

        try {
            auth.signInWithEmailAndPassword(uiState.value.email, uiState.value.password)

            // Başarılıysa "Remember Me" ayarına göre e-postayı kaydet veya sil
            if (uiState.value.isRememberMe) {
                // prefs.edit().putString("saved_email", uiState.value.email).apply()
            } else {
                //  prefs.edit().remove("saved_email").apply()
            }

            updateUiState { copy(isLoading = false) }
            emitUiEffect(SignInContract.UiEffect.NavigateHome)

        } catch (e: Exception) {
            val msg = when {
                e.message?.contains("user-not-found", ignoreCase = true) == true ->
                    "Böyle bir kullanıcı bulunamadı"

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