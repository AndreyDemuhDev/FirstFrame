package com.pidzama.firstframe

import android.app.Application
import com.pidzama.firstframe.di.DataBaseModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DataBaseModule.provideDB(applicationContext)
    }
}