package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.SearchEvent
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_design.view.*

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    private lateinit var contactsList:ArrayList<Contacts>
    private lateinit var adapter:ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title="Contact App"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        contactsList= ArrayList()

        val contact1 = Contacts(1,"Gokhan","123456789")
        val contact2 = Contacts(1,"Gokhan2","12345645")
        val contact3 = Contacts(1,"Gokhan3","123345745")

        contactsList.add(contact1)
        contactsList.add(contact2)
        contactsList.add(contact3)

        adapter = ContactsAdapter(this,contactsList)

        rv.adapter=adapter


        fab.setOnClickListener{
            alertShow()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    fun alertShow(){
        val design = LayoutInflater.from(this).inflate(R.layout.alert_design,null)
        val editTextAlertName = design.findViewById(R.id.editTextAlertName) as EditText
        val editTextAlertPhone = design.findViewById(R.id.editTextAlertPhone) as EditText

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Add Contact")
        alertDialog.setView(design)
        alertDialog.setPositiveButton("Add"){ dialogInterface, i->
            val contact_name = editTextAlertName.text.toString().trim()
            val contact_phone = editTextAlertPhone.text.toString().trim()

            Toast.makeText(applicationContext,"$contact_name-$contact_phone",Toast.LENGTH_SHORT).show()
        }
        alertDialog.setNegativeButton("Cancel"){ dialogInterface, i->

        }
        alertDialog.create().show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        Log.e("Sended search",query!!)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        Log.e("Letter to Letter",newText!!)
        return true
    }
}