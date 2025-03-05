package com.baitent.habit_compose

import android.app.Application
import com.baitent.habit_compose.di.initKoin

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}