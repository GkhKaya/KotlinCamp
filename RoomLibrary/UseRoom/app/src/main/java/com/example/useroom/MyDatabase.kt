package com.example.useroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getUsersDao():UsersDao

    companion object{
        var INSTANCE:MyDatabase?=null

        fun myDatabaseAccess(context: Context):MyDatabase? {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "guide.sqlite"
                    )
                        .createFromAsset("guide.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}