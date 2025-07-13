package com.baitent.habit_compose.presentation.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baitent.habit_compose.delegation.MVI
import com.baitent.habit_compose.delegation.mvi
import com.baitent.habit_compose.domain.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.baitent.habit_compose.presentation.features.splash.SplashContract.UiEffect
import com.baitent.habit_compose.presentation.features.splash.SplashContract.UiAction

class SplashViewModel(
    //private val userRepository: UserRepository
) : ViewModel() , MVI<Unit, UiAction, UiEffect> by mvi(Unit) {

    companion object {
        private const val SPLASH_DELAY = 1_000L
    }

    private val _isSplashVisible = MutableStateFlow(true)
    val isSplashVisible: StateFlow<Boolean> = _isSplashVisible.asStateFlow()

    private val _effect = MutableSharedFlow<UiEffect>()
    val effect: SharedFlow<UiEffect> = _effect.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(SPLASH_DELAY)
            _isSplashVisible.value = false
           // checkLogin()
        }
    }


}
