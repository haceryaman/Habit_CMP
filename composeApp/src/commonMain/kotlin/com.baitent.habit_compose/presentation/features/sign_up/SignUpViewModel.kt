package com.baitent.habit_compose.presentation.features.sign_up

import androidx.lifecycle.ViewModel
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth

class SignUpViewModel : ViewModel(),
    MVI<SignUpContract.UiState, SignUpContract.UiAction, SignUpContract.UiEffect> by mvi(
        SignUpContract.UiState()
    ) {

    private val auth: FirebaseAuth = Firebase.auth


    override suspend fun onAction(uiAction: SignUpContract.UiAction) {
        when (uiAction) {
            is SignUpContract.UiAction.OnEmailChange -> updateUiState { copy(email = uiAction.email).enableButtonIfValid() }
            is SignUpContract.UiAction.OnUserNameChange -> updateUiState { copy(username = uiAction.username).enableButtonIfValid() }
            is SignUpContract.UiAction.OnPasswordChange -> updateUiState { copy(password = uiAction.password).enableButtonIfValid() }
            is SignUpContract.UiAction.OnConfirmPasswordChange -> updateUiState {
                copy(
                    confirmPassword = uiAction.confirmPassword
                ).enableButtonIfValid()
            }

            SignUpContract.UiAction.OnSignUpClick -> handleSignUp()
            SignUpContract.UiAction.OnSignInClick -> emitUiEffect(SignUpContract.UiEffect.NavigateLogin)
            SignUpContract.UiAction.OnGoogleSignInClick -> emitUiEffect(SignUpContract.UiEffect.NavigateGoogleLogin)
            SignUpContract.UiAction.OnBackClick -> emitUiEffect(SignUpContract.UiEffect.NavigateBack)
            SignUpContract.UiAction.OnDialogDismiss -> updateUiState { copy(errorMessage = null) }
        }
    }

    private suspend fun handleSignUp() {
        updateUiState { copy(isLoading = true) }
        try {
            auth.createUserWithEmailAndPassword(uiState.value.email, uiState.value.password)
            updateUiState { copy(isLoading = false, isSuccess = true) }
            emitUiEffect(SignUpContract.UiEffect.NavigateLogin)
        } catch (e: Exception) {
            updateUiState { copy(isLoading = false, errorMessage = e.message) }
        }
    }

    private fun SignUpContract.UiState.enableButtonIfValid(): SignUpContract.UiState {
        val valid = email.isNotBlank() && username.isNotBlank()
                && password.isNotBlank() && confirmPassword.isNotBlank()
                && password == confirmPassword
        return copy(isButtonEnable = valid)
    }
}