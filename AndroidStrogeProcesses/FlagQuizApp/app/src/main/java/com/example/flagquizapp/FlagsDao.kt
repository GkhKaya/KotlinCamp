package com.example.flagquizapp

import android.annotation.SuppressLint

class FlagsDao() {

    @SuppressLint("Range")
    fun getRandomFiveFlags(dh:DatabaseHelper):ArrayList<Flags>{
        val flagList = ArrayList<Flags>()
        val db = dh.writableDatabase

        val cursor = db.rawQuery("select * from flags order by random() limit 5",null)

        while (cursor.moveToNext()){
            val flag = Flags(cursor.getInt(cursor.getColumnIndex("flag_id")),
                cursor.getString(cursor.getColumnIndex("flag_name")),
                cursor.getString(cursor.getColumnIndex("flag_image")),
                )
            flagList.add(flag)
        }
        return flagList
    }

    @SuppressLint("Range")
    fun getRandomFalseThreeFlags(dh:DatabaseHelper,flag_id:Int):ArrayList<Flags>{
        val flagList = ArrayList<Flags>()
        val db = dh.writableDatabase

        val cursor = db.rawQuery("select * from flags where flag_id!=$flag_id order by random() limit 3",null)

        while (cursor.moveToNext()){
            val flag = Flags(cursor.getInt(cursor.getColumnIndex("flag_id")),
                cursor.getString(cursor.getColumnIndex("flag_name")),
                cursor.getString(cursor.getColumnIndex("flag_image")),
            )
            flagList.add(flag)
        }
        return flagList
    }

}