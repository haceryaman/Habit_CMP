package com.baitent.habit_compose.presentation.features.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.R
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton


@Composable
fun WelcomeScreen(){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id= R.drawable.welcome), contentDescription = "Welcome")
        Text(text = "Welcome to Habit Compose", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Welcome to Habit ComposeWelcome to Habit ComposeWelcome to Habit ComposeWelc", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.padding(16.dp))
        CustomButton(text = "Register", onClick = {})
        Spacer(modifier = Modifier.padding(8.dp))
        CustomButton(text = "Login", onClick = {})

    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen()
}

