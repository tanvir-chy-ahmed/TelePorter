package com.xornex.tele.porter.domain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.xornex.tele.porter.domain.model.SmsData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class IncomingSmsReceiver(private val smslist: SnapshotStateList<SmsData>): BroadcastReceiver() {
//    override fun onReceive(context: Context?, intent: Intent?) {
//        if (intent?.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION || context == null) return
//
//        val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
//        val fullmessage =messages.joinToString("") {it.messageBody }
//        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
//
//        messages.forEach { sms ->
//            val sender = sms.displayOriginatingAddress
//            val body = sms.messageBody
//            val date = sdf.format(Date(sms.timestampMillis))
//
//            smslist.add(0, SmsData(UUID.randomUUID().toString(), sender, body, date))
//        }
//    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION || context == null) return

        // Get all parts of the SMS
        val messages = Telephony.Sms.Intents.getMessagesFromIntent(intent)

        // Concatenate all parts into one message
        val fullMessage = messages.joinToString("") { it.messageBody }

        // Format the timestamp of the first part (all parts usually share the same timestamp)
        val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(Date(messages[0].timestampMillis))

        // Get sender from the first part
        val sender = messages[0].displayOriginatingAddress ?: "Unknown"

        // Add the full message to your list
        smslist.add(0, SmsData(UUID.randomUUID().toString(), sender, fullMessage, date))
    }


}