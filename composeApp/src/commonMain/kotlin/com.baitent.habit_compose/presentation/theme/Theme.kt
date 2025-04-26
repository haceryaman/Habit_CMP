package com.baitent.habit_compose.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.baitent.habit_compose.common.HabitTypography

@Composable
fun HabitComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColors() else lightColors()

    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
           // colorScheme = ,
            typography = HabitTypography(),
            shapes = AppShapes,
            content = content
        )
    }
}

val AppShapes = Shapes()
