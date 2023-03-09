package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.databinding.ActivityMainBinding
import com.google.firebase.database.*

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    private lateinit var design:ActivityMainBinding
    private lateinit var contactsList:ArrayList<Contacts>
    private lateinit var adapter:ContactsAdapter
    private lateinit var refContacts: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this,R.layout.activity_main)

        design.toolbar.title="Contact App"
        setSupportActionBar(design.toolbar)

        design.rv.setHasFixedSize(true)
        design.rv.layoutManager = LinearLayoutManager(this)

        val db = FirebaseDatabase.getInstance()
        refContacts = db.getReference("contacts")

        contactsList= ArrayList()



        adapter = ContactsAdapter(this,contactsList,refContacts)

        design.rv.adapter=adapter

        allContacts()


        design.fab.setOnClickListener{
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

            val contact = Contacts("",contact_name,contact_phone)

            refContacts.push().setValue(contact)


            Toast.makeText(applicationContext,"$contact_name-$contact_phone",Toast.LENGTH_SHORT).show()
        }
        alertDialog.setNegativeButton("Cancel"){ dialogInterface, i->

        }
        alertDialog.create().show()
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        makeSearch(query)
        Log.e("Sended search",query!!)
        return true
    }
    override fun onQueryTextChange(newText: String): Boolean {
        makeSearch(newText)
        Log.e("Letter to Letter",newText!!)
        return true
    }

    fun allContacts(){
        refContacts.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                contactsList.clear()
                for(c in snapshot.children){
                    val contact = c.getValue(Contacts::class.java)

                    if(contact!=null){
                        contact.contact_id = c.key
                        contactsList.add(contact)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

    fun makeSearch(searchedWord:String){
        refContacts.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                contactsList.clear()
                for(c in snapshot.children){
                    val contact = c.getValue(Contacts::class.java)

                    if(contact!=null){
                            if(contact.contact_name!!.contains(searchedWord)){
                                contact.contact_id = c.key
                                contactsList.add(contact)
                            }


                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}