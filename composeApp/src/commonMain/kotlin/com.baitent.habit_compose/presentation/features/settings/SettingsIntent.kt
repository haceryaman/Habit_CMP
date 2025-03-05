package com.baitent.habit_compose.presentation.features.settings

sealed class SettingsIntent {
    data class UpdateEmail(val email: String) : SettingsIntent()
    data class UpdatePassword(val password: String) : SettingsIntent()
    object Login : SettingsIntent()
}