package com.baitent.habit_compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.baitent.habit_compose.navigation.NavigationGraph
import com.baitent.habit_compose.navigation.Screen
import com.baitent.habit_compose.presentation.theme.HabitComposeTheme

@Composable
fun App() {
    val navController = rememberNavController()
    HabitComposeTheme {
        NavigationGraph(
            modifier = Modifier,
            navController = navController,
            startDestination = Screen.Welcome
        )
    }
}