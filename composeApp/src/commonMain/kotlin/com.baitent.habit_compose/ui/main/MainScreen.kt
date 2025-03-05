package com.baitent.habit_compose.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.baitent.habit_compose.common.collectWithLifecycle
import com.baitent.habit_compose.ui.components.EmptyScreen
import com.baitent.habit_compose.ui.components.LoadingBar
import com.baitent.habit_compose.ui.main.MainContract.UiAction
import com.baitent.habit_compose.ui.main.MainContract.UiEffect
import com.baitent.habit_compose.ui.main.MainContract.UiState
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    uiEffect.collectWithLifecycle {

    }

    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> MainContent()
    }
}

@Composable
fun MainContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Main Content",
            fontSize = 24.sp,
        )
    }
}