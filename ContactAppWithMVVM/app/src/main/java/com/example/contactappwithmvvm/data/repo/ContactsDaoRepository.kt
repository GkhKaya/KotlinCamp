package com.example.contactappwithmvvm.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.contactappwithmvvm.data.entity.Contacts
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class ContactsDaoRepository(var refContacts:DatabaseReference) {
    var contactList:MutableLiveData<List<Contacts>>

    init {
        contactList = MutableLiveData()
    }

    fun getContacts():MutableLiveData<List<Contacts>>{
        return  contactList
    }

    fun addContact(contact_name:String,contact_phone:String){
        val newContacts = Contacts("",contact_name,contact_phone)
        refContacts.push().setValue(newContacts)
    }

    fun updateContact(contact_id:String,contact_name:String,contact_phone:String){
        val information = HashMap<String,Any>()
        information["contact_name"]=contact_name
        information["contact_phone"]=contact_phone

        refContacts.child(contact_id).updateChildren(information)
    }

    fun searchContact(searchedWord:String){
        refContacts.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Contacts>()

                for(d in snapshot.children){
                    val contact =d.getValue(Contacts::class.java)
                    if(contact!=null){
                        if(contact.contact_name!!.lowercase().contains(searchedWord.lowercase())){
                            contact.contact_id==d.key
                            list.add(contact)
                        }
                    }

                }
                contactList.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun deleteContact(contact_id:String){
        refContacts.child(contact_id).removeValue()
    }

    fun getAllContact(){
        refContacts.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<Contacts>()

                for(d in snapshot.children){
                    val contact =d.getValue(Contacts::class.java)
                    if(contact!=null){
                        contact.contact_id==d.key
                        list.add(contact)
                    }
                }
                contactList.value=list
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}