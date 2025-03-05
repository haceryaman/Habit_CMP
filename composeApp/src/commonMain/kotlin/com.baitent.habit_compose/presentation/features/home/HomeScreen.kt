package com.baitent.habit_compose.presentation.features.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.common.DummyData
import com.baitent.habit_compose.presentation.common.views.components.CardTodayHabitComponent

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    CardTodayHabitComponent(
        habits = DummyData.getHabits())
}