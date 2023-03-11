package com.example.contactappwithmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.contactappwithmvvm.R
import com.example.contactappwithmvvm.databinding.FragmentDetailContactBinding
import com.example.contactappwithmvvm.ui.vievmodel.AddContactViewModel
import com.example.contactappwithmvvm.ui.vievmodel.DetailContactViewModel
import com.example.contactappwithmvvm.ui.vievmodel.HomepageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailContactFragment : Fragment() {
    private lateinit var design:FragmentDetailContactBinding
    private lateinit var viewModel: DetailContactViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design =  DataBindingUtil.inflate(inflater,R.layout.fragment_detail_contact, container, false)

        design.contactDetailFragment=this
        design.detailContactToolbarTitle = "Detail Contact"

        val bundle:DetailContactFragmentArgs by navArgs()
        val incomingContact = bundle.contact

        design.contactObject = incomingContact

        return design.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetailContactViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(contact_id:String,contact_name:String,contact_phone:String){
        viewModel.update(contact_id,contact_name,contact_phone)
    }

}