package com.example.contactappwithmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.contactappwithmvvm.R
import com.example.contactappwithmvvm.databinding.FragmentAddContactBinding
import com.example.contactappwithmvvm.databinding.FragmentHomepageBinding
import com.example.contactappwithmvvm.ui.vievmodel.AddContactViewModel
import com.example.contactappwithmvvm.ui.vievmodel.DetailContactViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddContactFragment : Fragment() {
    private lateinit var design:FragmentAddContactBinding
    private lateinit var viewModel: AddContactViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_add_contact, container, false)

        design.addContactFragment = this
        design.addContactToolbarTitle = "Add Contact"



        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddContactViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonAdd(contact_name:String,contact_phone:String){
        viewModel.add(contact_name,contact_phone)
    }

}