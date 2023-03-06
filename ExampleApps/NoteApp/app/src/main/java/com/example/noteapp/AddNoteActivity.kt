package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class AddNoteActivity : AppCompatActivity() {
    private lateinit var dh: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        dh= DatabaseHelper(this)

        toolbarNoteAdd.title = "Add Note"
        setSupportActionBar(toolbarNoteAdd)

        buttonAddNote.setOnClickListener{

            val lesson_name = editTextAddLesson.text.toString().trim()
            val note_one = editTextTextAddNoteOne.text.toString().trim()
            val note_two = editTextTextAddNoteTwo.text.toString().trim()

            if(TextUtils.isEmpty(lesson_name)){
                Snackbar.make(toolbarNoteAdd,"Please enter the lesson name",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(note_one)){
                Snackbar.make(toolbarNoteAdd,"Please enter the note one",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(note_two)){
                Snackbar.make(toolbarNoteAdd,"Please enter the note two",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Notesdao().addNote(dh,lesson_name,note_one.toInt(),note_two.toInt())

            startActivity(Intent(this@AddNoteActivity,MainActivity::class.java))
            finish()
        }
    }
}