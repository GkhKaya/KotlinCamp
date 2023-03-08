package com.example.usesqlite

import android.annotation.SuppressLint
import android.content.ContentValues

class Usersdao {

    fun addUser(dh:DatabaseHelper,user_name:String,user_phone_number:String,user_age:Int,user_height:Double){
        val db = dh.writableDatabase
        val values = ContentValues()

        values.put("user_name",user_name)
        values.put("user_phone_number",user_phone_number)
        values.put("user_age",user_age)
        values.put("user_height",user_height)

        db.insertOrThrow("users",null,values)

        db.close()
    }

    @SuppressLint("Range")
    fun allUsers(dh: DatabaseHelper):ArrayList<Users>{
        val usersArrayList = ArrayList<Users>()
        val db = dh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM users",null)

        while (cursor.moveToNext()){
            val user = Users(
               cursor.getInt(cursor.getColumnIndex("user_id"))
               ,cursor.getString(cursor.getColumnIndex("user_name"))
               ,cursor.getString(cursor.getColumnIndex("user_phone_number"))
               ,cursor.getInt(cursor.getColumnIndex("user_age"))
               ,cursor.getDouble(cursor.getColumnIndex("user_height"))


            )
            usersArrayList.add(user)

        }
        return usersArrayList

    }

    fun updateUsers(dh: DatabaseHelper,user_no:Int,user_name:String,user_phone_number: String,user_age: Int,user_height: Double) {
        val db = dh.writableDatabase
        val values = ContentValues()

        values.put("user_name",user_name)
        values.put("user_phone_number",user_phone_number)
        values.put("user_age",user_age)
        values.put("user_height",user_height)

        db.update("users",values,"user_id=?", arrayOf(user_no.toString()))
        db.close()
    }

    fun deleteUsers(dh:DatabaseHelper,user_id:Int){
        val db = dh.writableDatabase
        db.delete("users", "user_id=?", arrayOf(user_id.toString()))
        db.close()
    }

    @SuppressLint("Range")
    fun searchUsers(dh:DatabaseHelper, keyWord:String):ArrayList<Users>{
        val usersArrayList=ArrayList<Users>()
        val db = dh.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE user_name like '%$keyWord%'",null)

        while (cursor.moveToNext()){
            val user = Users(
                cursor.getInt(cursor.getColumnIndex("user_id")),
                cursor.getString(cursor.getColumnIndex("user_name")),
                cursor.getString(cursor.getColumnIndex("user_phone_number")),
                cursor.getInt(cursor.getColumnIndex("user_age")),
                cursor.getDouble(cursor.getColumnIndex("user_height")),
            )
            usersArrayList.add(user)
        }
        return usersArrayList
    }

    @SuppressLint("Range")
    fun getRandomWord(dh: DatabaseHelper):ArrayList<Users>{
        val usersArrayList = ArrayList<Users>()
        val db = dh.writableDatabase
        val cursor = db.rawQuery("SELECT*FROM users ORDER BY RANDOM() LIMIT 5",null)
        while (cursor.moveToNext()){
            val user = Users(
                cursor.getInt(cursor.getColumnIndex("user_id")),
                cursor.getString(cursor.getColumnIndex("user_name")),
                cursor.getString(cursor.getColumnIndex("user_phone_number")),
                cursor.getInt(cursor.getColumnIndex("user_age")),
                cursor.getDouble(cursor.getColumnIndex("user_height")),
            )
            usersArrayList.add(user)
        }
        return usersArrayList
    }

    @SuppressLint("Range")
    fun checkEntry(dh:DatabaseHelper, user_name:String):Int{
        var result = 0
        var db = dh.writableDatabase
        var cursor = db.rawQuery("SELECT count(*) AS result FROM users WHERE user_name = '$user_name'",null)
        while(cursor.moveToNext()) {
            result = cursor.getInt(cursor.getColumnIndex("result"))

        }
        return result
    }

}