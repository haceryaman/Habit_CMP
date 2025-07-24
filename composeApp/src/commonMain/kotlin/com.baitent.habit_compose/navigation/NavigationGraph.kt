package com.baitent.habit_compose.navigation

import MainScreen
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.baitent.habit_compose.presentation.features.sign_in.SignInScreen
import com.baitent.habit_compose.presentation.features.sign_in.SignInViewModel
import com.baitent.habit_compose.presentation.features.sign_up.SignUpScreen
import com.baitent.habit_compose.presentation.features.sign_up.SignUpViewModel
import com.baitent.habit_compose.presentation.features.welcome.WelcomeScreen
import com.baitent.habit_compose.presentation.features.welcome.WelcomeViewModel
import com.baitent.habit_compose.presentation.features.main.MainViewModel
import com.baitent.habit_compose.presentation.theme.LocalColors
import org.koin.compose.viewmodel.koinViewModel
import com.baitent.habit_compose.navigation.Screen.Main
import com.baitent.habit_compose.navigation.Screen.Welcome
import com.baitent.habit_compose.navigation.Screen.SignUp
import com.baitent.habit_compose.navigation.Screen.SingIn
import com.baitent.habit_compose.presentation.features.splash.SplashScreen
import com.baitent.habit_compose.presentation.features.splash.SplashViewModel
import kotlinx.coroutines.launch

sealed class BottomNavItem(
    val screen: Screen,
    val icon: ImageVector,
    val label: String
) {
    data object Home : BottomNavItem(Main, Icons.Default.Home, "Ana Sayfa")

    // data object Habits : BottomNavItem(Welcome, Icons.Default.Search, "Ara")
    data object Profile : BottomNavItem(SignUp, Icons.Default.Person, "Profil")
}

private val bottomNavItems = listOf(
    BottomNavItem.Home,
    //  BottomNavItem.Search,
    BottomNavItem.Profile
)

private const val DURATION = 1000

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: Welcome,
    modifier: Modifier = Modifier
) {
    val hiddenRoutes = listOf(
        Welcome::class.qualifiedName,
        SignUp::class.qualifiedName,
        SingIn::class.qualifiedName,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry
        ?.destination
        ?.hierarchy
        ?.mapNotNull { it.route }
        ?.firstOrNull()

    Scaffold(
        modifier = modifier,
        containerColor = LocalColors.current.background,
        bottomBar = {
            if (currentRoute != null && currentRoute !in hiddenRoutes) {
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            label = { Text(item.label) },
                            selected = currentRoute == item.screen::class.qualifiedName,
                            onClick = {
                                navController.navigate(item.screen) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = LocalColors.current.primary,
                                unselectedIconColor = Color.Gray,
                                selectedTextColor = LocalColors.current.primary,
                                unselectedTextColor = Color.Gray
                            )
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier
                .then(modifier)
                .padding(innerPadding).padding(8.dp),
            navController = navController,
            startDestination = startDestination,
            enterTransition = { fadeIn(tween(DURATION)) },
            exitTransition = { fadeOut(tween(DURATION)) },
            popEnterTransition = { fadeIn(tween(DURATION)) },
            popExitTransition = { fadeOut(tween(DURATION)) }
        ) {
            composable<Main> {
                val vm = koinViewModel<MainViewModel>()
                val state by vm.uiState.collectAsStateWithLifecycle()
                val effect = vm.uiEffect
                MainScreen(
                    uiState = state,
                    uiEffect = effect,
                    onAction = vm::onAction
                )
            }
            composable<Screen.Splash> {
                val vm = koinViewModel<SplashViewModel>()
                val state by vm.uiState.collectAsStateWithLifecycle()
                val effect = vm.uiEffect
                SplashScreen(
                    onNavigateToHome = {
                        navController.navigate(Main)
                    },
                    onNavigateToWelcome = {
                        navController.navigate(Welcome)
                    },
                    uiEffect = effect,
                )
            }
            composable<Welcome> {
                val vm = koinViewModel<WelcomeViewModel>()
                val state by vm.uiState.collectAsStateWithLifecycle()
                val effect = vm.uiEffect
                WelcomeScreen(
                    onSignUpClick = { navController.navigate(SignUp) },
                    onSignInClick = { navController.navigate(SingIn) }
                )
            }
            composable<SignUp> {
                val vm = koinViewModel<SignUpViewModel>()
                val state by vm.uiState.collectAsStateWithLifecycle()
                val effect = vm.uiEffect
                val coroutineScope = rememberCoroutineScope()

                SignUpScreen(
                    onSignUp = { navController.navigate(Main) },
                    onSignIn = { navController.navigate(SingIn) },
                    onGoogleSignUp = { navController.navigate(Main) },
                    onBack = { navController.popBackStack() },
                    state = state,
                    uiEffect = effect,
                    viewModel = vm,
                    onAction = { action ->
                        coroutineScope.launch {
                           // vm.onAction(action)
                        }
                    }
                )
            }
            composable<SingIn> {
                val vm = koinViewModel<SignInViewModel>()
                val state by vm.uiState.collectAsStateWithLifecycle()
                val effect = vm.uiEffect
                SignInScreen(
                    viewModel = vm,
                    state = state,
                    uiEffect = effect,
                    onSignUp = { navController.navigate(SignUp) },
                    onSignIn = { navController.navigate(Main) },
                )
            }
        }
    }
}
