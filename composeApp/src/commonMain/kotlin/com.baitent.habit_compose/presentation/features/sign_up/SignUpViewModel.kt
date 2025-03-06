package com.baitent.habit_compose.presentation.features.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import com.baitent.habit_compose.ui.main.MainContract.UiAction
import com.baitent.habit_compose.ui.main.MainContract.UiEffect
import com.baitent.habit_compose.ui.main.MainContract.UiState
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel(), MVI<UiState, UiAction, UiEffect> by mvi(UiState()) {

    override fun onAction(uiAction: UiAction) {
        viewModelScope.launch {
        }
    }

}