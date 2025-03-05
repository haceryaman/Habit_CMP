package com.baitent.habit_compose.presentation.features.sign_up


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.baitent.habit_compose.R
import com.baitent.habit_compose.collectWithLifecycle
import com.baitent.habit_compose.presentation.common.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

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
            titleId = R.string.signUp,
            onClick = { onLoginClick() },
            textButtonTitleId = R.string.signIn
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            labelId = R.string.name,
            placeholderId = R.string.name,
            errorMessageId = R.string.nameEmpty,
            isPassword = false,
            onValueChanged = { onUsernameChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            labelId = R.string.email,
            placeholderId = R.string.emailPlaceholder,
            errorMessageId = R.string.emailError,
            isPassword = false,
            onValueChanged = { onEmailChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            labelId = R.string.password,
            placeholderId = R.string.passwordPlaceholder,
            errorMessageId = R.string.passwordError,
            isPassword = false,
            onValueChanged = { onPasswordChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            labelId = R.string.passwordConfirmation,
            placeholderId = R.string.passwordPlaceholder,
            errorMessageId = R.string.passwordConfirmationError,
            isPassword = false,
            onValueChanged = { onPasswordAgainChange(it) },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        CustomButton(
            text = stringResource(R.string.signUp),
            onClick = { onSignUpClick() }
        )
        CustomTextButton(
            textId = R.string.orLoginWith,
            onClick = { onLoginClick() },
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.white
        )

    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        onSignUpClick = { /* Handle sign up click */ },
        onLoginClick = { /* Handle login click */ },
        onNavigateBack = { /* Handle navigate back */ },
        onNavigateGoogleLogin = { /* Handle navigate google login */ },
        onNavigateLogin = { /* Handle navigate login */ },
        onEmailChange = { /* Handle email change */ },
        onUsernameChange = { /* Handle username change */ },
        onPasswordChange = { /* Handle password change */ },
        onPasswordAgainChange = { /* Handle password again change */ },
        uiState = SignUpContract.UiState(),
        uiEffect = flowOf(),
        onAction = { /* Handle action */ }
    )
}