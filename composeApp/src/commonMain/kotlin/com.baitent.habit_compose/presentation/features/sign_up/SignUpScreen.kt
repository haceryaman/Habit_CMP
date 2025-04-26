package com.baitent.habit_compose.presentation.features.sign_up

import CustomButton
import LoadingWidget
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
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
import androidx.compose.ui.Alignment
import com.baitent.habit_compose.presentation.common.views.components.BaseScaffold
import habit_compose.composeapp.generated.resources.google
import habit_compose.composeapp.generated.resources.ic_google
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    onSignIn: () -> Unit,
    onGoogleSignUp: () -> Unit,
    onSignUp: () -> Unit,
    onBack: () -> Unit,
    state: SignUpContract.UiState,
    uiEffect: Flow<SignUpContract.UiEffect>,
    onAction: (SignUpContract.UiAction) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiEffect) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                SignUpContract.UiEffect.NavigateLogin -> onSignIn()
                SignUpContract.UiEffect.NavigateGoogleLogin -> onGoogleSignUp()
                SignUpContract.UiEffect.NavigateBack -> onBack()
                SignUpContract.UiEffect.NavigateSignUp -> {
                    onSignUp()
                    snackbarHostState.showSnackbar("Kayıt başarılı!")
                }
            }
        }
    }

    LaunchedEffect(state.errorMessage) {
        state.errorMessage?.let { msg ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(msg)
            }
        }
    }

    LaunchedEffect(state.isSuccess) {
        if (state.isSuccess) {
            coroutineScope.launch {
                snackbarHostState.showSnackbar("Kayıt başarılı!", duration = SnackbarDuration.Short)
            }
        }
    }

    BaseScaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AuthLabel(
                    title = stringResource(Res.string.signUp),
                    onClick = onSignIn,
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
                    onClick = { onAction(SignUpContract.UiAction.OnSignUpClick) },
                    enabled = state.isButtonEnable,
                    loading = state.isLoading
                )

                Spacer(Modifier.weight(1f))

                Text(
                    text = stringResource(Res.string.orSignUpWith),
                    style= MaterialTheme.typography.bodySmall,
                )
                Spacer(Modifier.height(AppDimensions.smallPadding))
                CustomButton(
                    text = stringResource(Res.string.google),
                    iconPainter = painterResource(Res.drawable.ic_google),
                    onClick = { onAction(SignUpContract.UiAction.OnGoogleSignInClick) }
                )
            }
        }

        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                LoadingWidget()
            }
        }
    }
}