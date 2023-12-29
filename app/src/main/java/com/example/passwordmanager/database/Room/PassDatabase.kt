package com.example.passwordmanager.database.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities =[PassDao::class], version = 1, exportSchema = false
)
abstract class PassDatabase:RoomDatabase() {
    abstract fun passeDao(): PassDao
    companion object{
        @Volatile
        private var Instance: PassDatabase? = null
        fun getDatabase(context: Context): PassDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, PassDatabase::class.java,
                    "Password_Database").build().also {
                        Instance =it
                }
            }
        }

    }
}