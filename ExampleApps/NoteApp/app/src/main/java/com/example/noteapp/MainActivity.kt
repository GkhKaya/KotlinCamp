 package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

     private lateinit var notesList: ArrayList<Notes>
     private lateinit var adapter: NotesAdapter
     private lateinit var dh: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Note app"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)

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
}