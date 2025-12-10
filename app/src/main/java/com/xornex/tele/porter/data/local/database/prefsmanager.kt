package com.xornex.tele.porter.data.local.database

import android.content.Context

class PrefsManager(context: Context) {
    private val prefs = context.getSharedPreferences("telegram_shared_prefs", Context.MODE_PRIVATE)

    fun saveCreds(token: String, chatID: String) {
        prefs.edit().putString("token", token)
            .putString("chatID", chatID)
            .apply()
    }

    fun getCreds(): Pair<String, String>? {
        val token = prefs.getString("token", null)
        val chatId = prefs.getString("chatID", null)
        if (token.isNullOrEmpty() || chatId.isNullOrEmpty()) return null
        return token to chatId
    }
}
