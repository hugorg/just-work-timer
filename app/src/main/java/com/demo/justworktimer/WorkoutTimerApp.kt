package com.demo.justworktimer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WorkoutTimerApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}