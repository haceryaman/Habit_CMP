package com.baitent.habit_compose.presentation.features.home

sealed class HomeIntent {
    data class UpdateEmail(val email: String) : HomeIntent()
    data class UpdatePassword(val password: String) : HomeIntent()
    object Login : HomeIntent()
}