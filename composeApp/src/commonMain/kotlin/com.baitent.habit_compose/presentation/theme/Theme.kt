package com.baitent.habit_compose.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun Habit_composeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColors() else lightColors()

    // CompositionLocalProvider ile renkleri sağlayın.
    CompositionLocalProvider(LocalColors provides colors) {

        MaterialTheme(
          //  colorScheme = colors,
            //typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}

val AppShapes = Shapes()

