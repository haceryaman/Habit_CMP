package com.baitent.habit_compose.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    val route: String

    @Serializable
    data object Main    : Screen { override val route = "main" }
    @Serializable
    data object Welcome : Screen { override val route = "welcome" }
    @Serializable
    data object SignUp  : Screen { override val route = "sign_up" }
    @Serializable
    data object SingIn  : Screen { override val route = "sign_in" }
}