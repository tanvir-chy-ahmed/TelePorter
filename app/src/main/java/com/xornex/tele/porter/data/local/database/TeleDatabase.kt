package com.xornex.tele.porter.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TeleEntity::class], version = 1
)
abstract class TeleDatabase : RoomDatabase() {

    abstract fun TeleDao() : TeleDao

    companion object{


    }
}