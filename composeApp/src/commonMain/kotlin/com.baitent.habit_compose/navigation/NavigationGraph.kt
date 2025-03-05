package com.baitent.habit_compose.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baitent.habit_compose.ui.main.MainScreen
import com.baitent.habit_compose.ui.main.MainViewModel
import com.baitent.habit_compose.navigation.Screen.Main

private const val DURATION = 1000

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier,
) {
    val enterAnim = fadeIn(tween(DURATION))
    val exitAnim = fadeOut(tween(DURATION))

    NavHost(
        modifier = Modifier.then(modifier),
        navController = navController,
        startDestination = startDestination,
        enterTransition = { enterAnim },
        exitTransition = { exitAnim },
        popEnterTransition = { enterAnim },
        popExitTransition = { exitAnim },
    ) {
        composable<Main> {
            val viewModel = koinViewModel<MainViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            MainScreen(
                uiState = uiState,
                uiEffect = uiEffect,
                onAction = viewModel::onAction
            )
        }
    }
}