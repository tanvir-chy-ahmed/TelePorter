package com.xornex.tele.porter.domain.model

import java.util.Date

data class SmsData(
    val id: String,
    val sender: String,
    val body: String,
    val date : Date
)
