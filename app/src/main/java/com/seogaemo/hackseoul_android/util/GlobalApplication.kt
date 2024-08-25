package com.seogaemo.hackseoul_android.util

import android.app.Application
import com.seogaemo.hackseoul_android.database.SharedPreference

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreference.init(this)
    }
}