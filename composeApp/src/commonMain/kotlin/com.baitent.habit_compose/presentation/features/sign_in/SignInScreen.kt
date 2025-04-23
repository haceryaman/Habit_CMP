package com.baitent.habit_compose.presentation.features.sign_in

import CustomButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.theme.AppDimensions
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.email
import habit_compose.composeapp.generated.resources.emailPlaceholder
import habit_compose.composeapp.generated.resources.orLoginWith
import habit_compose.composeapp.generated.resources.password
import habit_compose.composeapp.generated.resources.passwordError
import habit_compose.composeapp.generated.resources.passwordPlaceholder
import habit_compose.composeapp.generated.resources.signIn
import habit_compose.composeapp.generated.resources.signUp
import org.jetbrains.compose.resources.stringResource

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(
    onSignUp: () -> Unit,
    onSignIn: ()-> Unit,
    onBack: ()-> Unit,
    onNavigateHome: () -> Unit,
    onGoogleSignIn: () -> Unit
) {
    val viewModel: SignInViewModel = viewModel()
    val state by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(viewModel.uiEffect) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                SignInContract.UiEffect.NavigateHome -> onNavigateHome()
                SignInContract.UiEffect.NavigateSignUp -> onSignUp()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimensions.mediumSpace)
    ) {
        Spacer(Modifier.height(AppDimensions.xxxLargeSpace))
        AuthLabel(
            title = stringResource(Res.string.signIn),
            onClick = onSignUp,
            textButtonTitle = stringResource(Res.string.signUp)
        )
        Spacer(Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            label = stringResource(Res.string.email),
            value = state.email,
            placeholderId = stringResource(Res.string.emailPlaceholder),
            errorMessageId = stringResource(Res.string.passwordError),
            isPassword = false,
            onValueChanged = { scope.launch { viewModel.onAction(SignInContract.UiAction.OnEmailChanged(it)) } }
        )
        Spacer(Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.password),
            value = state.password,
            placeholderId = stringResource(Res.string.passwordPlaceholder),
            errorMessageId = stringResource(Res.string.passwordError),
            isPassword = true,
            onValueChanged = { scope.launch { viewModel.onAction(SignInContract.UiAction.OnPasswordChanged(it)) } }
        )
        Spacer(Modifier.height(AppDimensions.mediumSpace))
        CustomButton(
            text = stringResource(Res.string.signIn),
            onClick = { scope.launch { viewModel.onAction(SignInContract.UiAction.OnSignInClick) } },
            enabled = state.isButtonEnable,
            loading = state.isLoading
        )
        state.errorMessage?.let { msg ->
            //ErrorDialog(message = msg) { scope.launch { viewModel.onAction(SignInContract.UiAction.OnDialogDismiss) } }
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = stringResource(Res.string.orLoginWith),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(AppDimensions.mediumSpace))
        CustomButton(
            text = null,
            icon = Icons.Outlined.Settings,
            onClick = { scope.launch { viewModel.onAction(SignInContract.UiAction.OnGoogleSignInClick) } }
        )
        Spacer(Modifier.weight(1f))
    }
}
