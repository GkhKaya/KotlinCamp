package com.example.contactappwithmvvm.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.contactappwithmvvm.R
import com.example.contactappwithmvvm.data.entity.Contacts
import com.example.contactappwithmvvm.databinding.CardDesignBinding
import com.example.contactappwithmvvm.ui.fragment.HomepageFragmentDirections
import com.example.contactappwithmvvm.ui.vievmodel.HomepageViewModel
import com.example.contactappwithmvvm.util.doTransition
import com.google.android.material.snackbar.Snackbar
import java.math.MathContext

class ContactAdapter(var mContext: Context,var contactList: List<Contacts>,var viewModel:HomepageViewModel) :
    RecyclerView.Adapter<ContactAdapter.CardDesignHolder>() {
    inner class CardDesignHolder(design:CardDesignBinding):RecyclerView.ViewHolder(design.root){
        val design:CardDesignBinding
        init {
            this.design=design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design:CardDesignBinding =DataBindingUtil.inflate(layoutInflater,R.layout.card_design, parent,false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val contact = contactList.get(position)
        val d = holder.design

        d.contactObject=contact

        d.lineCard.setOnClickListener {
            val transaction = HomepageFragmentDirections.detailContactTransition(contact = contact)
            Navigation.doTransition(transaction,it)
        }

        d.imageViewDelete.setOnClickListener{
            Snackbar.make(it,"${contact.contact_name} deleted ?",Snackbar.LENGTH_LONG)
                .setAction("yes"){
                    viewModel.delete(contact.contact_id!!)
                }.show()
        }
    }
}