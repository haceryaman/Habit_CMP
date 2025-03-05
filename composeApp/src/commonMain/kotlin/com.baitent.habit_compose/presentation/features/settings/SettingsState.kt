package com.baitent.habit_compose.presentation.features.settings

data class SettingsState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)