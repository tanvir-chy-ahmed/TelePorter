package com.xornex.tele.porter.util

import android.content.Context
import androidx.core.content.edit

class OnboardingUtils(private val context: Context) {
    fun isOnboadringCompleted(): Boolean {
        return context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)
            .getBoolean("completed", false)
    }

    fun setOnBoardingCompleted() {
        context.getSharedPreferences("onboarding", Context.MODE_PRIVATE)
            .edit {
                putBoolean("completed", true)
            }
    }

}