package com.baitent.habit_compose.presentation.features.sign_up


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import com.baitent.habit_compose.common.AppStrings
import com.baitent.habit_compose.common.collectWithLifecycle
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SignUpScreen(
    uiState: SignUpContract.UiState,
    uiEffect: Flow<SignUpContract.UiEffect>,
    onAction: (SignUpContract.UiAction) -> Unit,
    onNavigateBack: () -> Unit,
    onNavigateLogin: () -> Unit,
    onNavigateGoogleLogin: () -> Unit,
    onEmailChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordAgainChange: (String) -> Unit,
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
) {

    uiEffect.collectWithLifecycle { effect ->
        when (effect) {
            SignUpContract.UiEffect.NavigateBack -> onNavigateBack()
            SignUpContract.UiEffect.NavigateLogin -> onNavigateLogin()
            SignUpContract.UiEffect.NavigateGoogleLogin -> onNavigateGoogleLogin()
        }
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        AuthLabel(
            title = AppStrings.signUp,
            onClick = { onLoginClick() },
            textButtonTitle = AppStrings.signIn
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            label = AppStrings.name,
            placeholderId = AppStrings.namePlaceholder,
            errorMessageId = AppStrings.nameError,
            isPassword = false,
            onValueChanged = { onUsernameChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = AppStrings.email,
            placeholderId = AppStrings.emailPlaceholder,
            errorMessageId = AppStrings.emailError,
            isPassword = false,
            onValueChanged = { onEmailChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = AppStrings.password,
            placeholderId = AppStrings.passwordPlaceholder,
            errorMessageId = AppStrings.passwordError,
            isPassword = false,
            onValueChanged = { onPasswordChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = AppStrings.passwordConfirmation,
            placeholderId = AppStrings.passwordPlaceholder,
            errorMessageId = AppStrings.passwordConfirmationError,
            isPassword = false,
            onValueChanged = { onPasswordAgainChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        CustomButton(
            text = AppStrings.signUp,
            onClick = { onSignUpClick() }
        )
        CustomTextButton(
            text = AppStrings.signUp,
            onClick = { onLoginClick() },
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.white
        )

    }
}