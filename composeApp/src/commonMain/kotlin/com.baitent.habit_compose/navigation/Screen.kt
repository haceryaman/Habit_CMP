package com.baitent.habit_compose.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Main : Screen

    @Serializable
    data object Welcome : Screen

    @Serializable
    data object SignUp : Screen

    @Serializable
    data object SingIn : Screen


}