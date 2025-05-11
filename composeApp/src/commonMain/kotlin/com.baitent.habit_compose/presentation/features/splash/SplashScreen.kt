package com.baitent.habit_compose.presentation.features.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DocumentScanner
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.presentation.features.main.MainContract
import com.baitent.habit_compose.presentation.theme.LocalColors
import kotlinx.coroutines.flow.Flow

@Composable
fun SplashScreen(
    uiEffect: Flow<SplashContract.UiEffect>,
    onNavigateToHome: () -> Unit,
    onNavigateToWelcome: () -> Unit,
) {
    LaunchedEffect(uiEffect) {
        uiEffect.collect { effect ->
            when (effect) {
                is SplashContract.UiEffect.NavigateToHome -> onNavigateToHome()
                is SplashContract.UiEffect.NavigateToWelcome -> onNavigateToWelcome()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LocalColors.current.primary),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Filled.DocumentScanner,
            contentDescription = null,
            tint = LocalColors.current.white,
            modifier = Modifier.size(36.dp)
        )
    }
}