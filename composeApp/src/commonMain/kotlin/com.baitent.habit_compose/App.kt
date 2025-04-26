package com.baitent.habit_compose

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.baitent.habit_compose.navigation.NavigationGraph
import com.baitent.habit_compose.navigation.Screen
import com.baitent.habit_compose.presentation.theme.HabitComposeTheme
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun App() {
    val navController = rememberNavController()
    HabitComposeTheme {
        Scaffold(
            containerColor = LocalColors.current.background,
        ) {
            NavigationGraph(
                modifier = Modifier,
                navController = navController,
                startDestination = Screen.Welcome
            )
        }
    }
}