//Use with sqlite
/**package com.example.noteapp

import android.annotation.SuppressLint
import android.content.ContentValues

class Notesdao {

    @SuppressLint("Range")
    fun allNotes(dh:DatabaseHelper,):ArrayList<Notes>{
        val db = dh.writableDatabase
        val notesList = ArrayList<Notes>()
        val cursor = db.rawQuery("SELECT * FROM notes",null)
        while (cursor.moveToNext()){
            val note = Notes(cursor.getInt(cursor.getColumnIndex("note_id"))
                ,cursor.getString(cursor.getColumnIndex("lesson_name"))
                ,cursor.getInt(cursor.getColumnIndex("note_one"))
                ,cursor.getInt(cursor.getColumnIndex("note_two")))

            notesList.add(note)
        }
        return notesList
    }


    fun deleteNote(dh:DatabaseHelper,note_id:Int){
        val db = dh.writableDatabase
        db.delete("notes","note_id=?", arrayOf(note_id.toString()))
        db.close()
    }
    fun addNote(dh:DatabaseHelper,lesson_name:String,note_one:Int,note_two:Int){
        val db = dh.writableDatabase

        val values = ContentValues()
        values.put("lesson_name",lesson_name)
        values.put("note_one",note_one)
        values.put("note_two",note_two)

        db.insertOrThrow("notes",null,values)
        db.close()
    }

    fun updateNote(dh:DatabaseHelper,note_id:Int,lesson_name:String,note_one:Int,note_two:Int){
        val db = dh.writableDatabase

        val values = ContentValues()
        values.put("lesson_name",lesson_name)
        values.put("note_one",note_one)
        values.put("note_two",note_two)

        db.update("notes",values,"note_id=?", arrayOf(note_id.toString()))
        db.close()
    }
}**/