package com.example.contactappwithmvvm.ui.vievmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.contactappwithmvvm.data.repo.ContactsDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailContactViewModel @Inject constructor(var contactRepo:ContactsDaoRepository):ViewModel() {

    fun update(contact_id:String,contact_name:String,contact_phone:String){
        contactRepo.updateContact(contact_id,contact_name,contact_phone)
    }
}