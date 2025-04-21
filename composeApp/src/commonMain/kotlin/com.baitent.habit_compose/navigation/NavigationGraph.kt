package com.baitent.habit_compose.navigation

import MainScreen
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import org.koin.compose.viewmodel.koinViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.baitent.habit_compose.presentation.features.welcome.WelcomeViewModel
import com.baitent.habit_compose.ui.main.MainViewModel
import com.baitent.habit_compose.navigation.Screen.Main
import com.baitent.habit_compose.presentation.features.sign_in.SignInScreen
import com.baitent.habit_compose.presentation.features.sign_in.SignInViewModel
import com.baitent.habit_compose.presentation.features.sign_up.SignUpScreen
import com.baitent.habit_compose.presentation.features.sign_up.SignUpViewModel
import com.baitent.habit_compose.presentation.features.welcome.WelcomeScreen

sealed class BottomNavItem(
    val screen: Screen,
    val icon: ImageVector,
    val label: String
) {
     object Home    : BottomNavItem(Screen.Main,   Icons.Default.Home,   "Ana Sayfa")
     object Search  : BottomNavItem(Screen.Welcome, Icons.Default.Search, "Ara")
     object Profile : BottomNavItem(Screen.SignUp,  Icons.Default.Person, "Profil")
}

private val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Search,
    BottomNavItem.Profile
)

private const val DURATION = 1000

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Screen,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            NavigationBar {
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentDestination?.hierarchy
                            ?.any { it.route == item.screen.route } == true,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
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
                MainScreen()
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
}