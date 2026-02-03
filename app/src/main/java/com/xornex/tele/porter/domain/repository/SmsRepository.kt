package com.xornex.tele.porter.domain.repository

import android.content.Context
import android.net.Uri
import android.provider.Telephony
import com.xornex.tele.porter.domain.model.SmsData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SmsRepository(private val context: Context) {
    fun getAllSms(): List<SmsData> {
        val smsList = mutableListOf<SmsData>()
        val uri: Uri = Telephony.Sms.Inbox.CONTENT_URI
        val cursor = context.contentResolver.query(
            uri,
            arrayOf(
                Telephony.Sms._ID,
                Telephony.Sms.ADDRESS,
                Telephony.Sms.BODY,
                Telephony.Sms.DATE
            ),
            null,
            null,
            Telephony.Sms.DEFAULT_SORT_ORDER
        )

        cursor?.use {
            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
            while (it.moveToNext()) {
                val id = it.getString(it.getColumnIndexOrThrow(Telephony.Sms._ID))
                val sender = it.getString(it.getColumnIndexOrThrow(Telephony.Sms.ADDRESS))
                val body = it.getString(it.getColumnIndexOrThrow(Telephony.Sms.BODY))
                val timestamp = it.getLong(it.getColumnIndexOrThrow(Telephony.Sms.DATE))
                val date = sdf.format(Date(timestamp))

                smsList.add(SmsData(id, sender, body, date))
            }
        }
        return smsList
    }
}