package com.baitent.habit_compose.presentation.features.sign_in

object SignInContract {
    data class UiState(
        val email: String = "",
        val password: String = "",
        val isLoading: Boolean = false,
        val errorMessage: String? = null,
        val isButtonEnabled: Boolean = false
    )

    sealed class UiAction {
        data class OnEmailChanged(val email: String) : UiAction()
        data class OnPasswordChanged(val password: String) : UiAction()
        data object OnSignInClick : UiAction()
        data object OnGoogleSignInClick : UiAction()
        data object OnSignUpClick : UiAction()
        data object OnDialogDismiss : UiAction()
    }

    sealed class UiEffect {
        data object NavigateHome : UiEffect()
        data object NavigateSignUp : UiEffect()
    }
}
