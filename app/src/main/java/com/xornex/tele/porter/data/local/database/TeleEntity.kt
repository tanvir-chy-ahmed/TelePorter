package com.xornex.tele.porter.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tele_table")
data class TeleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val timestamp : Long,
    val senderAddress: String,
    val body: String,
    val numberOfSms : Int, // inbox = 1,0
    val read : Boolean
)
