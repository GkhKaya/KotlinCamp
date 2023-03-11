package com.example.contactappwithmvvm.ui.vievmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactappwithmvvm.data.repo.ContactsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(var contactRepo:ContactsDaoRepository):ViewModel(){
    fun add(contact_name:String,contact_phone:String){
        contactRepo.addContact(contact_name,contact_phone)
    }
}