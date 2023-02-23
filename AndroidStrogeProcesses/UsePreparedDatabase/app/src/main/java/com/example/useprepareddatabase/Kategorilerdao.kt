package com.example.useprepareddatabase

import android.annotation.SuppressLint

class Kategorilerdao {

    @SuppressLint("Range")
    fun getAllCategories(dh:DatabaseHelper):ArrayList<Kategoriler>{

        val categoryList = ArrayList<Kategoriler>()

        val db = dh.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM karegoriler",null)

        while (cursor.moveToNext()){
            val kategori = Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id")),
                    cursor.getString(cursor.getColumnIndex("kategori_ad")))

            categoryList.add(kategori)

        }
        return categoryList
    }
}