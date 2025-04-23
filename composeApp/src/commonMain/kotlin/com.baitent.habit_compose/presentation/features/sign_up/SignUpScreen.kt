package com.baitent.habit_compose.presentation.features.sign_up

import CustomButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.theme.AppDimensions
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.email
import habit_compose.composeapp.generated.resources.emailError
import habit_compose.composeapp.generated.resources.emailPlaceholder
import habit_compose.composeapp.generated.resources.name
import habit_compose.composeapp.generated.resources.nameError
import habit_compose.composeapp.generated.resources.namePlaceholder
import habit_compose.composeapp.generated.resources.orSignUpWith
import habit_compose.composeapp.generated.resources.password
import habit_compose.composeapp.generated.resources.passwordConfirmation
import habit_compose.composeapp.generated.resources.passwordConfirmationError
import habit_compose.composeapp.generated.resources.passwordError
import habit_compose.composeapp.generated.resources.passwordPlaceholder
import habit_compose.composeapp.generated.resources.signIn
import habit_compose.composeapp.generated.resources.signUp
import org.jetbrains.compose.resources.stringResource
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = viewModel(),
    onSignIn: () -> Unit,
    onGoogleSignIn: () -> Unit,
    onSignUp: () -> Unit,
    onBack: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(viewModel.uiEffect) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                SignUpContract.UiEffect.NavigateLogin -> onSignIn()
                SignUpContract.UiEffect.NavigateGoogleLogin -> onGoogleSignIn()
                SignUpContract.UiEffect.NavigateBack -> onBack()
                SignUpContract.UiEffect.NavigateSignUp -> onSignUp()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.mediumSpace)
    ) {
        AuthLabel(
            title = stringResource(Res.string.signUp),
            onClick = onBack,
            textButtonTitle = stringResource(Res.string.signIn)
        )
        Spacer(Modifier.height(AppDimensions.xxxLargeSpace))

        TextFieldItem(
            label = stringResource(Res.string.name),
            value = state.username,
            onValueChanged = { new ->
                coroutineScope.launch {
                    viewModel.onAction(SignUpContract.UiAction.OnUserNameChange(new))
                }
            },
            placeholderId = stringResource(Res.string.namePlaceholder),
            errorMessageId = stringResource(Res.string.nameError),
            isPassword = false
        )
        Spacer(Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.email),
            value = state.email,
            onValueChanged = { new ->
                coroutineScope.launch {
                    viewModel.onAction(SignUpContract.UiAction.OnEmailChange(new))
                }
            },
            placeholderId = stringResource(Res.string.emailPlaceholder),
            errorMessageId = stringResource(Res.string.emailError),
            isPassword = false
        )
        Spacer(Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.password),
            value = state.password,
            isPassword = true,
            onValueChanged = { new ->
                coroutineScope.launch {
                    viewModel.onAction(SignUpContract.UiAction.OnPasswordChange(new))
                }
            },
            placeholderId = stringResource(Res.string.passwordPlaceholder),
            errorMessageId = stringResource(Res.string.passwordError)
        )
        Spacer(Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.passwordConfirmation),
            value = state.confirmPassword,
            isPassword = true,
            onValueChanged = { new ->
                coroutineScope.launch {
                    viewModel.onAction(SignUpContract.UiAction.OnConfirmPasswordChange(new))
                }
            },
            placeholderId = stringResource(Res.string.passwordPlaceholder),
            errorMessageId = stringResource(Res.string.passwordConfirmationError)
        )
        Spacer(Modifier.height(AppDimensions.xxxLargeSpace))

        CustomButton(
            text = stringResource(Res.string.signUp),
            onClick = {
                coroutineScope.launch {
                    viewModel.onAction(SignUpContract.UiAction.OnSignUpClick)
                }
            },
            enabled = state.isButtonEnable,
            loading = state.isLoading
        )
        Spacer(modifier = Modifier.weight(1f))

        state.errorMessage?.let {
        }

        Spacer(Modifier.weight(1f))

        CustomButton(
            text = stringResource(Res.string.orSignUpWith),
            icon = Icons.Outlined.Settings,
            onClick = {
                coroutineScope.launch {
                    viewModel.onAction(SignUpContract.UiAction.OnGoogleSignInClick)
                }
            }
        )
    }
}
