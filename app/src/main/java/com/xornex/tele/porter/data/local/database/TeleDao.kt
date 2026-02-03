package com.xornex.tele.porter.data.local.database

import android.telephony.SmsMessage
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TeleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSMS(message: TeleEntity)

    @Query("SELECT * FROM tele_table ORDER BY timestamp DESC")
    fun getAllSMS() : Flow<List<TeleEntity>>

    @Query("SELECT * FROM tele_table WHERE senderAddress = :phone ORDER BY timestamp ASC")
    fun getConversation(phone : String) : Flow<List<TeleEntity>>


    @Query("UPDATE tele_table SET read = 1 WHERE senderAddress =:phone")
    suspend fun markAsRead(phone : String)

//    @Query("DELETE FROM tele_table WHERE id = :id")
//    suspend fun deleteSMS(id: Int)


}