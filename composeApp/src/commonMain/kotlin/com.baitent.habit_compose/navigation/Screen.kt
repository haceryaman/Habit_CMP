package com.baitent.habit_compose.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Main : Screen
}