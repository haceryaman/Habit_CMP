package com.baitent.habit_compose.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.baitent.habit_compose.common.collectWithLifecycle
import com.baitent.habit_compose.ui.components.EmptyScreen
import com.baitent.habit_compose.ui.components.LoadingBar
import com.baitent.habit_compose.ui.main.MainContract.UiAction
import com.baitent.habit_compose.ui.main.MainContract.UiEffect
import com.baitent.habit_compose.ui.main.MainContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun MainScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {
    // Side‑effect’leri topla
    uiEffect.collectWithLifecycle { effect ->
        // …
    }

    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> MainContent()
    }
}

@Composable
fun MainContent() {
    val todayText = remember { getTodayFormattedDate() }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = todayText,
            fontSize = 24.sp
        )
    }
}

fun getTodayFormattedDate(): String {
    val today = Clock.System
        .now()
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date

    val weekday = today.dayOfWeek
        .name
        .lowercase()
        .replaceFirstChar { it.uppercase() }

    val month = today.month
        .name
        .lowercase()
        .replaceFirstChar { it.uppercase() }

    return "$weekday, ${today.dayOfMonth} $month ${today.year}"
}
