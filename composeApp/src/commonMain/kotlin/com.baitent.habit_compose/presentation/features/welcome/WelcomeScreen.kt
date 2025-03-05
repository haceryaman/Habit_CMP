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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.baitent.habit_compose.R
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors


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
        Image(painter = painterResource(id = R.drawable.welcome), contentDescription = "Welcome")
        Spacer(modifier = Modifier.height(AppDimensions.xLargeSpace))
        Text(text = stringResource( R.string.welcome), style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        Text(
            text = stringResource(R.string.welcomeDescription),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(AppDimensions.largeSpace))
        CustomButton(text = stringResource(R.string.signUp), onClick = onSignUpClick)
        Spacer(modifier = Modifier.padding(AppDimensions.mediumSpace))
        CustomButton(text = stringResource(R.string.signIn), onClick = onSignInClick)

    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(
        onSignUpClick = {},
        onSignInClick = {},
        viewModel = WelcomeViewModel()
    )
}

