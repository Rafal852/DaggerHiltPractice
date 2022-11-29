package com.example.hilttraining

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

const val TAG = "HiltTag"

@HiltAndroidApp
class MyApp : Application() {
}