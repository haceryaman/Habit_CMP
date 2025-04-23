package com.baitent.habit_compose.presentation.features.sign_in

object SignInContract {
    data class UiState(
        val email: String = "",
        val password: String = "",
        val isLoading: Boolean = false,
        val isSuccess: Boolean = false,
        val errorMessage: String? = null,
        val isButtonEnable: Boolean = false
    )

    sealed class UiAction {
        object OnEmailChange : UiAction() {
            operator fun invoke(email: String) = OnEmailChanged(email)
        }
        data class OnEmailChanged(val email: String) : UiAction()
        object OnPasswordChange : UiAction() {
            operator fun invoke(password: String) = OnPasswordChanged(password)
        }
        data class OnPasswordChanged(val password: String) : UiAction()
        object OnSignInClick : UiAction()
        object OnGoogleSignInClick : UiAction()
        object OnDialogDismiss : UiAction()
    }

    sealed class UiEffect {
        object NavigateHome : UiEffect()
        object NavigateSignUp : UiEffect()
    }
}