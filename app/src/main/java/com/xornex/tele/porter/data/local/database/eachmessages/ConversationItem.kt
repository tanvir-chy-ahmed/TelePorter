package com.xornex.tele.porter.data.local.database.eachmessages

data class ConversationItem (
    val senderAddress: String,
    val senderName: String,
    val body: String,
    val time: Long,
    val unreadCount: Int,
    val numberOfSms : Int,
    val read : Boolean

)