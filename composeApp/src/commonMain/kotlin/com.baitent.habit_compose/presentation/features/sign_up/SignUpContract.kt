package com.baitent.habit_compose.presentation.features.sign_up

object SignUpContract {
    /**
     * Bu UiState, ekranın anlık olarak nasıl görünmesi gerektiğini tek bir kaynak üzerinden tanımlar.
     * Proje genelinde herhangi bir yerden durum yönetimi yapılırken, state güncellenerek arayüzün otomatik olarak güncellenmesi sağlanır.
     */

    data class UiState(
        val isLoading: Boolean = false,
        val isSuccess: Boolean = false,
        val errorMessage: String? = null,
        val email: String = "",
        val username: String = "",
        val password: String = "",
        val confirmPassword: String = "",
        //    val dialogState: DialogState? = null,
        val isButtonEnable: Boolean = false,
    )
    {
        /*  fun setSuccessDialog(message: String?): UiState {
              return copy(dialogState = DialogState(isSuccess = true, message = message), isLoading = false)
          }
          fun setErrorDialog(message: String?): UiState {
              return copy(dialogState = DialogState(isSuccess = false, message = message), isLoading = false)
          }

          fun checkButtonEnabled() = email.isNotEmpty() && username.isNotEmpty() &&
                  password.isNotEmpty() && passwordAgain.isNotEmpty()
                  */
    }

    /**
     * UiAction, ekran üzerindeki kullanıcı etkileşimlerini veya arka planda tetiklenen olayları temsil eder.
     * Bu eylemleri ViewModelde işleyerek yeni bir UiState oluşturabilir ya da UiEffect üretebilir.
     */

    sealed class UiAction {
        data object OnBackClick : UiAction()
        data class OnEmailChange(val email: String) : UiAction()
        data class OnUserNameChange(val username: String) : UiAction()
        data class OnPasswordChange(val password: String) : UiAction()
        data class OnConfirmPasswordChange(val confirmPassword: String) : UiAction()
        data object OnSignUpClick : UiAction()
        data object OnSignInClick : UiAction()
        data object OnGoogleSignInClick : UiAction()
        data object OnDialogDismiss : UiAction()
    }

    /**
     * UiEffect genellikle arayüzde tek seferlik gerçekleştirilen (navigasyon, toast, diyalog açma/kapatma vb.) işlemleri belirtir.
     * Bu tür işlemler, sürekli olarak UI ile senkronize olma gerektirmediği için “state” yerine ayrı bir yapı olarak tanımlanır.
     * Örneğin, isLoading bir state’tir ve UI’da sürekli güncel olması gerekir.
     * Ama NavigateBack tek bir kez tetiklenip, ekranda navigasyonu gerçekleştirip sonlanır.
     */

    sealed class UiEffect {
        data object NavigateBack : UiEffect()
        data object NavigateLogin : UiEffect()
        data object NavigateGoogleLogin : UiEffect()
        data object NavigateSignUp: UiEffect()
    }
}