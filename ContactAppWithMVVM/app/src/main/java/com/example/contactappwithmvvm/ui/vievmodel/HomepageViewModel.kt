package com.example.contactappwithmvvm.ui.vievmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.contactappwithmvvm.data.entity.Contacts
import com.example.contactappwithmvvm.data.repo.ContactsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var contactRepo:ContactsDaoRepository):ViewModel() {
    var contactList = MutableLiveData<List<Contacts>>()

    init {
        loadContacts()
        contactList = contactRepo.getContacts()
    }


    fun search(searchedWord:String){
        contactRepo.searchContact(searchedWord)
    }

    fun delete(contact_id:String){
        contactRepo.deleteContact(contact_id)
    }

    fun loadContacts(){
        contactRepo.getAllContact()
    }
}