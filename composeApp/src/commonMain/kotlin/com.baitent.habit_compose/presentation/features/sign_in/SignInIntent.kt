package com.baitent.habit_compose.presentation.features.sign_in

sealed class SignInIntent {
    data class UpdateEmail(val email: String) : SignInIntent()
    data class UpdatePassword(val password: String) : SignInIntent()
    object Login : SignInIntent()
}