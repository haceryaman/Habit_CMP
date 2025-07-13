package com.baitent.habit_compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.baitent.habit_compose.domain.repository.UserRepository
import com.baitent.habit_compose.navigation.NavigationGraph
import com.baitent.habit_compose.navigation.Screen
import com.baitent.habit_compose.presentation.theme.HabitComposeTheme
import org.koin.compose.getKoin

@Composable
fun App() {
    val navController = rememberNavController()

    val userRepo: UserRepository = getKoin().get()

    HabitComposeTheme {
        NavigationGraph(
            modifier = Modifier,
            navController = navController,
            startDestination = Screen.Main
        )
    }
}