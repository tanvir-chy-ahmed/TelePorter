package com.xornex.tele.porter.domain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import com.xornex.tele.porter.data.local.preference.PrefsManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null || intent?.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return

        // EXTEND RECEIVER LIFETIME
        val pendingResult = goAsync()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                if (messages.isEmpty()) return@launch

                // Concatenate all parts into one full message
                val fullMessage = messages.joinToString("") { it.messageBody }

                // Use first part's sender and timestamp
                val sender = messages[0].displayOriginatingAddress ?: "Unknown"
                val date = Date(messages[0].timestampMillis)
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                val formattedDate = sdf.format(date)

                // Prepare Telegram text
                val formattedText =
                    "📩 *New SMS Received*\n\n" +
                            "*From:* $sender\n" +
                            "*Date:* $formattedDate\n" +
                            "*Message:*\n$fullMessage"

                // Send once to Telegram
                sendToTelegram(context, formattedText)

            } catch (e: Exception) {
                Log.e("SmsReceiver", "Error processing SMS", e)
            } finally {
                // VERY IMPORTANT: release receiver
                pendingResult.finish()
            }
        }
    }


    private fun sendToTelegram(context: Context, text: String) {
        val prefs = PrefsManager(context)
        val creds = prefs.getCreds() ?: return
        val (botToken, chatId) = creds

        val encodedText = URLEncoder.encode(text, "UTF-8")

        val url =
            "https://api.telegram.org/bot$botToken/sendMessage" +
                    "?chat_id=$chatId&text=$encodedText&parse_mode=Markdown"

        // CLIENT WITH LONG TIMEOUT (PREVENT TIMEOUT)
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        try {
            val request = Request.Builder().url(url).build()
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    Log.e("SmsReceiver", "Telegram send failed: ${response.code}")
                }
            }
        } catch (e: Exception) {
            Log.e("SmsReceiver", "Error sending message to Telegram", e)
        }
    }
}
