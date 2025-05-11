package com.baitent.habit_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.baitent.habit_compose.presentation.features.splash.SplashViewModel
import com.google.android.play.integrity.internal.s
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    private val splashViewModel:SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen= installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition{
            splashViewModel.isSplashVisible.value
        }
        FirebaseApp.initializeApp(this)
        setContent {
            App()
        }
    }
}
