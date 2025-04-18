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
import com.baitent.habit_compose.presentation.features.welcome.WelcomeViewModel
import com.baitent.habit_compose.ui.main.MainScreen
import com.baitent.habit_compose.ui.main.MainViewModel
import com.baitent.habit_compose.navigation.Screen.Main
import com.baitent.habit_compose.presentation.features.sign_in.SignInScreen
import com.baitent.habit_compose.presentation.features.sign_in.SignInViewModel
import com.baitent.habit_compose.presentation.features.sign_up.SignUpScreen
import com.baitent.habit_compose.presentation.features.sign_up.SignUpViewModel
import com.baitent.habit_compose.presentation.features.welcome.WelcomeScreen

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
        composable<Screen.Welcome> {
            val viewModel = koinViewModel<WelcomeViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            WelcomeScreen(
                onSignUpClick = { navController.navigate(Screen.SignUp) },
                onSignInClick = { navController.navigate(Screen.SingIn) }
            )
        }
        composable<Screen.SignUp> {
            val viewModel = koinViewModel<SignUpViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SignUpScreen(
                onSignUpClick = { navController.navigate(Screen.Main) },
                onSignInClick = { navController.navigate(Screen.SingIn) },
                onGoogleSignInClick = { navController.navigate(Screen.Main) },
            )
        }
        composable<Screen.SingIn> {
            val viewModel = koinViewModel<SignInViewModel>()
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiEffect = viewModel.uiEffect
            SignInScreen(
                onSignUpClick = { navController.navigate(Screen.Main) },
                onSignInClick = { navController.navigate(Screen.SingIn) },
                onGoogleSignUpClick = { navController.navigate(Screen.Main) },
            )
        }
    }
}