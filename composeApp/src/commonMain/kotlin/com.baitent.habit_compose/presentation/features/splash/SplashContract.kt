package com.baitent.habit_compose.presentation.features.splash

object SplashContract {
    sealed class UiAction

    sealed class UiEffect {
        data object NavigateToHome    : UiEffect()
        data object NavigateToWelcome : UiEffect()
    }
}