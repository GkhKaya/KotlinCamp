package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {

    private lateinit var note:Notes
    //Use with sqlite
    //private lateinit var dh:DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbarNoteDetail.title= "Note Detail"
        setSupportActionBar(toolbarNoteDetail)
        //Use with sqlite
        //dh=DatabaseHelper(this)

        note =intent.getSerializableExtra("object") as Notes

        editTextDetailLesson.setText(note.lesson_name)
        editTextDetailNoteOne.setText((note.not_one).toString())
        editTextDetailNoteTwo.setText((note.not_two).toString())


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_delete->{
                Snackbar.make(toolbarNoteDetail,"Do you want to delete?",Snackbar.LENGTH_SHORT)
                    .setAction("YES"){
                        deleteNote(note.note_id)
                        //Use with sqlite
                        //Notesdao().deleteNote(dh, note.note_id )
                        startActivity(Intent(this@DetailActivity,MainActivity::class.java))
                        finish()
                    }.show()
                return true
            }
            R.id.action_edit->{
                val lesson_name = editTextDetailLesson.text.toString().trim()
                val note_one = editTextDetailNoteOne.text.toString().trim()
                val note_two = editTextDetailNoteTwo.text.toString().trim()

                if(TextUtils.isEmpty(lesson_name)){
                    Snackbar.make(toolbarNoteDetail,"Please enter the lesson name",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(note_one)){
                    Snackbar.make(toolbarNoteDetail,"Please enter the note one",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(note_two)){
                    Snackbar.make(toolbarNoteDetail,"Please enter the note two",Snackbar.LENGTH_SHORT).show()
                    return false
                }

                updateNote(note.note_id,lesson_name,note_one.toInt(),note_two.toInt())
                //Use with sqlite
                //Notesdao().updateNote(dh,note.note_id,lesson_name,note_one.toInt(),note_two.toInt())
                startActivity(Intent(this@DetailActivity,MainActivity::class.java))
                finish()
                return true
            }
            else -> return false
        }
    }
    fun updateNote(note_id:Int,lesson_name:String,note_one:Int,note_two:Int){
        val url = "https://gkhkaya.com/kotlincamp/note_app/update_note.php"

        val request = object : StringRequest(Request.Method.POST,url, Response.Listener{ result->

        }, Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["note_id"]=note_id.toString()
                params["lesson_name"]=lesson_name
                params["note_one"]=note_one.toString()
                params["note_two"]=note_two.toString()
                return params
            }
        }

        Volley.newRequestQueue(this@DetailActivity).add(request)
    }

    fun deleteNote(note_id:Int){
        val url = "https://gkhkaya.com/kotlincamp/note_app/delete_note.php"

        val request = object : StringRequest(Request.Method.POST,url, Response.Listener{ result->

        }, Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String>()
                params["note_id"]=note_id.toString()
                return params
            }
        }

        Volley.newRequestQueue(this@DetailActivity).add(request)
    }
}