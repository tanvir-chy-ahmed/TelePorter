package com.xornex.tele.porter.data.local.database

import android.content.Context
import androidx.core.content.edit

class PrefsManager(context: Context) {
    private val prefs = context.getSharedPreferences("telegram_shared_prefs", Context.MODE_PRIVATE)

    fun saveCreds(token: String, chatID: String) {
        prefs.edit().apply {
            putString("botToken", token)
            putString("chatId", chatID)
            apply()
        }
    }

    fun getCreds(): Pair<String, String>? {
        val token = prefs.getString("botToken", null)
        val chatId = prefs.getString("chatId", null)
        return if (!token.isNullOrEmpty() && !chatId.isNullOrEmpty()) {
            Pair(token, chatId)
        } else null
    }


    fun clearCreds(){
        prefs.edit().clear().apply()
    }
}

