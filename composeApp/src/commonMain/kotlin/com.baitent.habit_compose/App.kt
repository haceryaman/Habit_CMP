package com.baitent.habit_compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.baitent.habit_compose.navigation.NavigationGraph
import com.baitent.habit_compose.navigation.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ) {
            NavigationGraph(
                modifier = Modifier.padding(it).padding(20.dp),
                navController = navController,
                startDestination = Screen.Main
            )
        }
    }
}