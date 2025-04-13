package com.baitent.habit_compose.presentation.features.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.ui.main.MainContract.UiAction
import com.baitent.habit_compose.ui.main.MainContract.UiEffect
import com.baitent.habit_compose.ui.main.MainContract.UiState
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.signIn
import habit_compose.composeapp.generated.resources.signUp
import habit_compose.composeapp.generated.resources.welcome
import habit_compose.composeapp.generated.resources.welcomeDescription
import kotlinx.coroutines.flow.Flow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun WelcomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.welcome),
            contentDescription = "Welcome"
        )
        Spacer(modifier = Modifier.height(AppDimensions.xLargeSpace))
        Text(stringResource(Res.string.welcome), style = MaterialTheme.typography.displayMedium)
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        Text(
            text = stringResource(Res.string.welcomeDescription),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(AppDimensions.largeSpace))
        CustomButton(text = stringResource(Res.string.signUp), onClick = onSignUpClick)
        Spacer(modifier = Modifier.padding(AppDimensions.mediumSpace))
        CustomButton(text = stringResource(Res.string.signIn), onClick = onSignInClick)

    }
}