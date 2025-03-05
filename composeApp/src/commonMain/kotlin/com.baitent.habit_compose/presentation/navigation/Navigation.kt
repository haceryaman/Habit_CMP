package com.baitent.habit_compose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baitent.habit_compose.presentation.features.sign_up.SignUpContract
import com.baitent.habit_compose.presentation.features.sign_up.SignUpScreen
import com.baitent.habit_compose.presentation.features.sign_in.SigninScreen
import com.baitent.habit_compose.features.welcome.WelcomeScreen
import com.baitent.habit_compose.features.welcome.WelcomeViewModel
import kotlinx.coroutines.flow.flowOf

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
 //   val currentUser = FirebaseAuth.getInstance().currentUser
    NavHost(
        navController = navController,
        startDestination = NavRoute.WELCOME.route,
        modifier = modifier
    ) {
        composable(NavRoute.WELCOME.route) {


        }
        composable(NavRoute.SIGNUP.route) {

            SignUpScreen(
                uiState = SignUpContract.UiState(), // Varsayılan UIState
                uiEffect = flowOf(),
                onAction = { /* İşlem yapılabilir */ },
                onNavigateBack = { navController.popBackStack() },
                onNavigateLogin = { navController.navigate(NavRoute.SIGNIN.route) },
                onNavigateGoogleLogin = { /* Google login işlemi yapılabilir */ },
                onEmailChange = { /* Email değişimi işlemi yapılabilir */ },
                onUsernameChange = { /* Kullanıcı adı değişimi işlemi yapılabilir */ },
                onPasswordChange = { /* Şifre değişimi işlemi yapılabilir */ },
                onPasswordAgainChange = { /* Şifre tekrar değişimi işlemi yapılabilir */ },
                onSignUpClick = { /* Kayıt olma işlemi yapılabilir */ },
                onLoginClick = { navController.navigate(NavRoute.SIGNIN.route) }
            )
        }
        composable(NavRoute.SIGNIN.route) {
            SigninScreen(

            )
        }
    }
}