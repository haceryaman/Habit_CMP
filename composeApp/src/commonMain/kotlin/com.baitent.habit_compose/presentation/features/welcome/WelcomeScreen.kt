package com.baitent.habit_compose.presentation.features.welcome

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
import com.baitent.habit_compose.common.AppStrings
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.ui.main.MainContract.UiAction
import com.baitent.habit_compose.ui.main.MainContract.UiEffect
import com.baitent.habit_compose.ui.main.MainContract.UiState
import kotlinx.coroutines.flow.Flow


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
        //Image(painter = , contentDescription = "Welcome")
        Spacer(modifier = Modifier.height(AppDimensions.xLargeSpace))
        Text(text = AppStrings.welcome, style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        Text(
            text = AppStrings.welcomeDescription,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(AppDimensions.largeSpace))
        CustomButton(text = AppStrings.signUp, onClick = onSignUpClick)
        Spacer(modifier = Modifier.padding(AppDimensions.mediumSpace))
        CustomButton(text = AppStrings.signUp, onClick = onSignInClick)

    }
}