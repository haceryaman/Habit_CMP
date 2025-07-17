package com.baitent.habit_compose.presentation.features.main

import com.baitent.habit_compose.presentation.common.views.components.Period
import com.baitent.habit_compose.presentation.common.views.components.HabitType

object MainContract {
    data class UiState(
        val showDialog: Boolean = false,
        val goalText: String = "",
        val habitName: String = "",
        val expandedPeriod: Boolean = false,
        val expandedType: Boolean = false,
        val selectedPeriod: Period = Period.OneMonth,
        val selectedType: HabitType = HabitType.Everyday
    )

    sealed class UiAction {
        data object ShowDialog : UiAction()
        data object DismissDialog : UiAction()
        data class SetGoal(val text: String) : UiAction()
        data class SetName(val text: String) : UiAction()
        data object TogglePeriodDropdown : UiAction()
        data class SelectPeriod(val p: Period) : UiAction()
        data object ToggleTypeDropdown : UiAction()
        data class SelectType(val t: HabitType) : UiAction()
        data object CreateClicked : UiAction()
    }

    sealed class UiEffect {
        data object HabitCreated : UiEffect()
        data class Error(val message: String) : UiEffect()
    }
}