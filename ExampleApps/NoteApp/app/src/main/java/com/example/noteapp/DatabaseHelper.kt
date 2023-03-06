package com.example.noteapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context:Context):SQLiteOpenHelper(context,"note.sqlite",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE  notes(note_id INTEGER PRIMARY KEY AUTOINCREMENT,lesson_name TEXT, note_one INTEGER, note_two INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS notes")
        onCreate(db)
    }
}