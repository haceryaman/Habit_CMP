package com.baitent.habit_compose.presentation.features.sign_in

import CustomButton
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.presentation.common.views.components.BaseScaffold
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.theme.AppDimensions
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.email
import habit_compose.composeapp.generated.resources.emailPlaceholder
import habit_compose.composeapp.generated.resources.google
import habit_compose.composeapp.generated.resources.ic_google
import habit_compose.composeapp.generated.resources.orLoginWith
import habit_compose.composeapp.generated.resources.password
import habit_compose.composeapp.generated.resources.passwordPlaceholder
import habit_compose.composeapp.generated.resources.signIn
import habit_compose.composeapp.generated.resources.signUp
import kotlinx.coroutines.flow.Flow


@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    state: SignInContract.UiState,
    uiEffect: Flow<SignInContract.UiEffect>,
    onSignIn: () -> Unit,
    onSignUp: () -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(uiEffect) {
        uiEffect.collect { effect ->
            when (effect) {
                SignInContract.UiEffect.NavigateHome -> onSignIn()
                SignInContract.UiEffect.NavigateSignUp -> onSignUp()
                is SignInContract.UiEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(effect.message)
                }
            }
        }
    }

    LaunchedEffect(state.errorMessage) {
        state.errorMessage?.let { msg ->
            snackbarHostState.showSnackbar(msg, duration = SnackbarDuration.Short)
            scope.launch {
                viewModel.onAction(SignInContract.UiAction.OnDialogDismiss)
            }
        }
    }

    BaseScaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(AppDimensions.xxxLargeSpace))

            AuthLabel(
                title = stringResource(Res.string.signIn),
                onClick = onSignUp,
                textButtonTitle = stringResource(Res.string.signUp)
            )

            Spacer(Modifier.height(AppDimensions.xxxLargeSpace))

            TextFieldItem(
                errorMessageId = state.errorMessage ?: "",
                label = stringResource(Res.string.email),
                value = state.email,
                placeholderId = stringResource(Res.string.emailPlaceholder),
                isPassword = false,
                onValueChanged = { new ->
                    scope.launch {
                        viewModel.onAction(SignInContract.UiAction.OnEmailChanged(new))
                    }
                }
            )

            Spacer(Modifier.height(AppDimensions.smallSpace))

            TextFieldItem(
                errorMessageId = state.errorMessage ?: "",
                label = stringResource(Res.string.password),
                value = state.password,
                placeholderId = stringResource(Res.string.passwordPlaceholder),
                isPassword = true,
                onValueChanged = { new ->
                    scope.launch {
                        viewModel.onAction(SignInContract.UiAction.OnPasswordChanged(new))
                    }
                }
            )

            Spacer(Modifier.height(AppDimensions.mediumSpace))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = state.isRememberMe,
                    onCheckedChange = { checked ->
                        scope.launch {
                            viewModel.onAction(SignInContract.UiAction.OnRememberMeToggled(checked))
                        }
                    }
                )
                Text(text = "Remember Me")
                Spacer(Modifier.weight(1f))
                TextButton(
                    onClick = {
                        scope.launch {
                            viewModel.onAction(SignInContract.UiAction.OnForgotPasswordClick)
                        }
                    }
                ) {
                    Text(text = "Forgot Password?")
                }
            }

            Spacer(Modifier.height(AppDimensions.mediumSpace))

            CustomButton(
                text = stringResource(Res.string.signIn),
                onClick = { scope.launch { viewModel.onAction(SignInContract.UiAction.OnSignInClick) } },
                enabled = state.isButtonEnabled,
                loading = state.isLoading
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = stringResource(Res.string.orLoginWith),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.height(AppDimensions.mediumSpace))

            CustomButton(
                text = stringResource(Res.string.google),
                iconPainter = painterResource(Res.drawable.ic_google),
                onClick = { scope.launch { viewModel.onAction(SignInContract.UiAction.OnGoogleSignInClick) } },
                enabled = !state.isLoading
            )
            Spacer(Modifier.weight(1f))
        }
    }
}