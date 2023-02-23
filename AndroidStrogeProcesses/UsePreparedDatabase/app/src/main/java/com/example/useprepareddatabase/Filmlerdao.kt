package com.example.useprepareddatabase

import android.annotation.SuppressLint

class Filmlerdao {

    @SuppressLint("Range")
    fun getAllFilmsByCategoryId(dh:DatabaseHelper, kategori_id:Int):ArrayList<Filmler>{

        val filmsList = ArrayList<Filmler>()

        val db = dh.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM filmler,karegoriler,yonetmenler Where filmler.kategori_id=kategoriler.kategori_id and filmler.yonetmen_id=yonetmenler.yonetmen_id and filmler.kategori_id=$kategori_id",null)

        while (cursor.moveToNext()){
            val kategori = Kategoriler(cursor.getInt(cursor.getColumnIndex("kategori_id")),
                cursor.getString(cursor.getColumnIndex("kategori_ad")))
            val yonetmen = Yonetmenler(cursor.getInt(cursor.getColumnIndex("yonetmen_id")),
                cursor.getString(cursor.getColumnIndex("yonetmen_ad")))

            val film = Filmler(cursor.getInt(cursor.getColumnIndex("film_id"))
                ,cursor.getString(cursor.getColumnIndex("film_Ad"))
                ,cursor.getInt(cursor.getColumnIndex("film_yil"))
                ,cursor.getString(cursor.getColumnIndex("film_resim")),kategori,yonetmen)

            filmsList.add(film)

        }
        return filmsList
    }

}