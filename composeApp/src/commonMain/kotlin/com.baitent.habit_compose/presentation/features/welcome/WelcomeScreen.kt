package com.baitent.habit_compose.features.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.style.TextAlign
import com.baitent.habit_compose.common.AppStrings
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource


@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel,
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       // Image(painter = , contentDescription = "Welcome")
        Spacer(modifier = Modifier.height(AppDimensions.xLargeSpace))
        Text(text = AppStrings.welcome, style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        Text(
            text = AppStrings.welcomeDescription,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(AppDimensions.largeSpace))
        //CustomButton(text = AppStrings.signUp), onClick = onSignUpClick)
        Spacer(modifier = Modifier.padding(AppDimensions.mediumSpace))
        //CustomButton(text = stringResource(R.string.signIn), onClick = onSignInClick)

    }
}