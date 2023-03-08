package com.example.dictionaryapp

import android.annotation.SuppressLint
import java.io.StringWriter

class Wordsdao {

    @SuppressLint("Range")
    fun tumKelimeler(dh:DatabaseHelper): ArrayList<Words> {
        val wordsArrayList = ArrayList<Words>()
        val db = dh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM words", null)
        while (cursor.moveToNext()) {
            val k = Words(
                cursor.getInt(cursor.getColumnIndex("word_id"))
                , cursor.getString(cursor.getColumnIndex("english"))
                , cursor.getString(cursor.getColumnIndex("turkish"))
            )
            wordsArrayList.add(k)
        }
        return wordsArrayList
    }

    @SuppressLint("Range")
    fun doSearch(dh:DatabaseHelper,searchedWord:String): ArrayList<Words> {
        val wordsArrayList = ArrayList<Words>()
        val db = dh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM words WHERE english like '%$searchedWord%'", null)
        while (cursor.moveToNext()) {
            val k = Words(
                cursor.getInt(cursor.getColumnIndex("word_id"))
                , cursor.getString(cursor.getColumnIndex("english"))
                , cursor.getString(cursor.getColumnIndex("turkish"))
            )
            wordsArrayList.add(k)
        }
        return wordsArrayList
    }
}