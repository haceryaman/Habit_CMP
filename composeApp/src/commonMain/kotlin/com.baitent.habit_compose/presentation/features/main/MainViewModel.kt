package com.baitent.habit_compose.presentation.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import com.baitent.habit_compose.presentation.features.main.MainContract.UiAction
import com.baitent.habit_compose.presentation.features.main.MainContract.UiEffect
import com.baitent.habit_compose.presentation.features.main.MainContract.UiState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override suspend fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
        }
    }
}