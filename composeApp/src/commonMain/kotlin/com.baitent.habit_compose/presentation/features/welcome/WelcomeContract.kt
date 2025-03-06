package com.baitent.habit_compose.presentation.features.welcome

object WelcomeContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction
    sealed class UiEffect
}