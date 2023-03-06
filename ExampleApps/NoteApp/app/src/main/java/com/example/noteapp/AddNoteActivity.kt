package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.lang.Exception

class AddNoteActivity : AppCompatActivity() {

    //use with sqlite
    //private lateinit var dh: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        //use with sqlite
        //dh= DatabaseHelper(this)

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

            addNote(lesson_name,note_one.toInt(),note_two.toInt())

            //use with sqlite
            //Notesdao().addNote(dh,lesson_name,note_one.toInt(),note_two.toInt())

            startActivity(Intent(this@AddNoteActivity,MainActivity::class.java))
            finish()
        }
    }

    fun addNote(lesson_name:String,note_one:Int,note_two:Int){
        val url = "https://gkhkaya.com/kotlincamp/note_app/insert_note.php"

        val request = object : StringRequest(Request.Method.POST,url, Response.Listener{ result->

        }, Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["lesson_name"]=lesson_name
                params["note_one"]=note_one.toString()
                params["note_two"]=note_two.toString()
                return params
            }
        }

        Volley.newRequestQueue(this@AddNoteActivity).add(request)
    }
}