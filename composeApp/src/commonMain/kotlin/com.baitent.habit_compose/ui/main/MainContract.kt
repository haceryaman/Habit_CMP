package com.baitent.habit_compose.ui.main

object MainContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction
    sealed class UiEffect
}