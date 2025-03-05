package com.baitent.habit_compose.presentation.features.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baitent.habit_compose.delegate.MVI
import com.baitent.habit_compose.delegate.mvi
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpViewModel : ViewModel(), MVI<SignUpContract.UiState, SignUpContract.UiAction, SignUpContract.UiEffect> by mvi(
    SignUpContract.UiState()
), KoinComponent {

    // FirebaseAuth nesnesini Koin üzerinden inject ediyoruz.
    private val firebaseAuth: FirebaseAuth by inject()

    override fun onAction(uiAction: SignUpContract.UiAction) {
        viewModelScope.launch {
            when (uiAction) {
                SignUpContract.UiAction.OnBackClick -> {
                    updateUiState { copy() }
                    emitUiEffect(SignUpContract.UiEffect.NavigateBack)
                }

                is SignUpContract.UiAction.OnEmailChange -> {
                    updateUiState { copy(email = uiAction.email, isButtonEnable = checkButtonEnabled()) }
                }

                is SignUpContract.UiAction.OnUserNameChange -> {
                    updateUiState { copy(username = uiAction.username, isButtonEnable = checkButtonEnabled()) }
                }

                is SignUpContract.UiAction.OnPasswordChange -> {
                    updateUiState { copy(password = uiAction.password, isButtonEnable = checkButtonEnabled()) }
                }

                is SignUpContract.UiAction.OnConfirmPasswordChange->{
                    updateUiState { copy(confirmPassword = uiAction.confirmPassword, isButtonEnable = checkButtonEnabled()) }
                }

                SignUpContract.UiAction.OnSignUpClick -> signup()

                SignUpContract.UiAction.OnSignInClick -> {
                    emitUiEffect(SignUpContract.UiEffect.NavigateLogin)
                }

                SignUpContract.UiAction.OnGoogleSignInClick -> {
                    emitUiEffect(SignUpContract.UiEffect.NavigateGoogleLogin)
                }

                SignUpContract.UiAction.OnDialogDismiss -> {
                    /* if (currentUiState.dialogState?.isSuccess == true) {
                         emitUiEffect(UiEffect.NavigateBack)
                     } else {
                         updateUiState { copy(dialogState = null) }
                     }*/
                }
            }
        }
    }

    private fun signup() {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            firebaseAuth.createUserWithEmailAndPassword(currentUiState.email, currentUiState.password)
                .addOnCompleteListener { task ->
                    viewModelScope.launch {
                        if (task.isSuccessful) {
                            // updateUiState { setSuccessDialog("Kayıt başarılı!") }
                            emitUiEffect(SignUpContract.UiEffect.NavigateLogin)
                        } else {
                            // updateUiState { setErrorDialog(task.exception?.message ?: "Bir hata oluştu") }
                        }
                    }
                }
        }
    }

    /**
     * Alanların dolu olup olmadığını ve şifrelerin eşleşip eşleşmediğini kontrol eder.
     */
    private fun checkButtonEnabled(): Boolean {
        val state = currentUiState
        return state.email.isNotBlank() &&
                state.username.isNotBlank() &&
                state.password.isNotBlank() &&
                state.confirmPassword.isNotBlank() &&
                state.password == state.confirmPassword
    }
}