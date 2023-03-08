package com.example.usesqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context:Context) : SQLiteOpenHelper(context,"guide", null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE users (user_id INTEGER PRIMARY KEY AUTOINCREMENT, user_name TEXT,user_phone_number TEXT, user_age INTEGER, user_height DOUBLE );")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
}


