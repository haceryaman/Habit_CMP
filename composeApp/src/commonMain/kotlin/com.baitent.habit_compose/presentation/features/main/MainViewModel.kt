package com.baitent.habit_compose.presentation.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import com.baitent.habit_compose.presentation.features.main.MainContract.UiAction
import com.baitent.habit_compose.presentation.features.main.MainContract.UiEffect
import com.baitent.habit_compose.presentation.features.main.MainContract.UiState
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.FieldValue
import dev.gitlive.firebase.firestore.firestore
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(),
    MVI<UiState, UiAction, UiEffect>
    by mvi(UiState()) {

    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore


    override fun onAction(uiAction: UiAction) {
        when (uiAction) {
            UiAction.ShowDialog -> updateUiState { copy(showDialog = true) }
            UiAction.DismissDialog -> updateUiState { copy(showDialog = false) }

            is UiAction.SetGoal ->
                updateUiState { copy(goalText = uiAction.text) }

            is UiAction.SetName ->
                updateUiState { copy(habitName = uiAction.text) }

            UiAction.TogglePeriodDropdown ->
                updateUiState { copy(expandedPeriod = !expandedPeriod) }

            is UiAction.SelectPeriod ->
                updateUiState {
                    copy(
                        selectedPeriod = uiAction.p,
                        expandedPeriod = false
                    )
                }

            UiAction.ToggleTypeDropdown ->
                updateUiState { copy(expandedType = !expandedType) }

            is UiAction.SelectType ->
                updateUiState {
                    copy(
                        selectedType = uiAction.t,
                        expandedType = false
                    )
                }

            UiAction.CreateClicked -> {
                val state = uiState.value
                val uid = auth.currentUser?.uid
                if (uid.isNullOrBlank()) {
                    return
                }
                viewModelScope.launch {
                    try {
                        firestore
                            .collection("users")
                            .document(uid)
                            .collection("habits")
                            .add(
                                mapOf(
                                    "goal" to state.goalText,
                                    "name" to state.habitName,
                                    "period" to state.selectedPeriod.label,
                                    "type" to state.selectedType.label,
                                    "createdAt" to FieldValue.serverTimestamp
                                )
                            )
                        updateUiState { UiState() }
                        emitUiEffect(UiEffect.HabitCreated)
                    } catch (e: Exception) {
                        emitUiEffect(UiEffect.Error("Kaydetme hatası: ${e.message}"))
                    }
                }
            }
        }
    }
}
