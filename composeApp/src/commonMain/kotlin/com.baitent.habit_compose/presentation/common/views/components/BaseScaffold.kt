package com.baitent.habit_compose.presentation.common.views.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun BaseScaffold(
    modifier: Modifier = Modifier.fillMaxSize(),
    containerColor: Color = LocalColors.current.background,
    snackbarHost: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        containerColor = containerColor,
        content = content,
        snackbarHost = snackbarHost,
        modifier = modifier,
    )
}