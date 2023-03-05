package com.example.flagquizapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,"flagquiz.sqlite",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS \"flags\" (\n" +
                "\t\"flag_id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"flag_name\"\tTEXT,\n" +
                "\t\"flag_image\"\tTEXT\n" +
                ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS flags")
        onCreate(db)
    }
}