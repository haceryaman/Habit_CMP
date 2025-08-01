package com.baitent.habit_compose.presentation.features.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baitent.habit_compose.data.models.UserEntity
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel(),
    MVI<SignUpContract.UiState, SignUpContract.UiAction, SignUpContract.UiEffect> by mvi(
        SignUpContract.UiState()
    ) {

    private val auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore

    override fun onAction(uiAction: SignUpContract.UiAction) {
        when (uiAction) {
            is SignUpContract.UiAction.OnEmailChange ->
                updateUiState { copy(email = uiAction.email).enableButtonIfValid() }

            is SignUpContract.UiAction.OnUserNameChange ->
                updateUiState { copy(username = uiAction.username).enableButtonIfValid() }

            is SignUpContract.UiAction.OnPasswordChange ->
                updateUiState { copy(password = uiAction.password).enableButtonIfValid() }

            is SignUpContract.UiAction.OnConfirmPasswordChange ->
                updateUiState {
                    copy(confirmPassword = uiAction.confirmPassword)
                        .enableButtonIfValid()
                }

            SignUpContract.UiAction.OnSignInClick ->
                viewModelScope.launch {
                    emitUiEffect(SignUpContract.UiEffect.NavigateLogin)
                }

            SignUpContract.UiAction.OnGoogleSignInClick ->
                viewModelScope.launch {
                    emitUiEffect(SignUpContract.UiEffect.NavigateGoogleLogin)
                }

            SignUpContract.UiAction.OnBackClick ->
                viewModelScope.launch {
                    emitUiEffect(SignUpContract.UiEffect.NavigateBack)
                }

            SignUpContract.UiAction.OnDialogDismiss ->
                updateUiState { copy(errorMessage = null) }

            SignUpContract.UiAction.OnSignUpClick ->
                handleSignUp()
        }
    }


    private fun handleSignUp() {
        viewModelScope.launch {
            updateUiState { copy(isLoading = true) }
            try {
                auth.createUserWithEmailAndPassword(
                    uiState.value.email,
                    uiState.value.password
                )

                val userEntity = UserEntity(
                    email = uiState.value.email,
                    userName = uiState.value.username,
                    firstName = null,
                    lastName = null,
                    avatarUrl = null,
                    isRememberMe = null
                )

                db.collection("users")
                    .document(uiState.value.email)
                    .set(userEntity)

                updateUiState { copy(isLoading = false, isSuccess = true) }
                emitUiEffect(SignUpContract.UiEffect.NavigateSignUp)
            } catch (e: Exception) {
                updateUiState { copy(isLoading = false, errorMessage = e.message) }
            }
        }
    }

    private fun SignUpContract.UiState.enableButtonIfValid(): SignUpContract.UiState {
        val valid = email.isNotBlank()
                && username.isNotBlank()
                && password.isNotBlank()
                && confirmPassword.isNotBlank()
                && password == confirmPassword
        return copy(isButtonEnable = valid)
    }
}