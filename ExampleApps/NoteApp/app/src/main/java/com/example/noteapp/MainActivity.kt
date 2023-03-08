 package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
 import com.android.volley.toolbox.Volley
 import com.android.volley.toolbox.StringRequest
 import com.android.volley.*
import com.android.volley.Request.Method
import org.json.JSONObject

 class MainActivity : AppCompatActivity() {

     private lateinit var notesList: ArrayList<Notes>
     private lateinit var adapter: NotesAdapter

     //Use with sqlite
     //private lateinit var dh: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Note app"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)
         allnotes()


       //Use with sqlite
       /**
        dh = DatabaseHelper(this)

        val notesdao = Notesdao()
        notesList = notesdao.allNotes(dh)

        adapter = NotesAdapter(this,notesList)
        rv.adapter = adapter

        var total = 0

        for(n in notesList){
            total = total + (n.not_one+n.not_two)/2
        }
        if(total !=0){
            toolbar.subtitle="Avarage : ${total/notesList.size}"
        }
        **/

        fab.setOnClickListener{
            startActivity(Intent(this@MainActivity,AddNoteActivity::class.java))
        }


    }

     override fun onBackPressed() {
         val intent = Intent(Intent.ACTION_MAIN)
         intent.addCategory(Intent.CATEGORY_HOME)
         intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
         startActivity(intent)
     }

     fun allnotes(){
         val url = "https://gkhkaya.com/kotlincamp/note_app/all_notes.php"

         val request = StringRequest(Request.Method.GET,url,Response.Listener{result->
            try {

                var total = 0
                notesList = ArrayList()

                val jsonObject = JSONObject(result)
                val notes = jsonObject.getJSONArray("notes")

                for(i in 0 until notes.length()){
                    val n = notes.getJSONObject(i)

                    val note_one = n.getInt("note_one")
                    val note_two = n.getInt("note_two")

                    val note = Notes(n.getInt("note_id")
                        ,n.getString("lesson_name")
                        ,note_one
                        ,note_two)

                    notesList.add(note)

                    total = total + (note_one+note_two) / 2
                }

                adapter = NotesAdapter(this,notesList)
                rv.adapter=adapter

                if (total != 0){
                    toolbar.subtitle = "Avarage ${total/notesList.size}"
                }
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
         },Response.ErrorListener {  })

         Volley.newRequestQueue(this@MainActivity).add(request)



     }
}