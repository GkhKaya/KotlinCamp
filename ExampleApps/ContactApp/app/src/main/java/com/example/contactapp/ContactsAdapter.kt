package com.example.contactapp

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*

class ContactsAdapter(private val mContext: Context,private val contactsList: List<Contacts>,private val refContacts:DatabaseReference):RecyclerView.Adapter<ContactsAdapter.HolderCardDesign>() {
    inner class HolderCardDesign(design:View):RecyclerView.ViewHolder(design){
        var textViewContactInformation:TextView
        var imageViewMore:ImageView

        init {
            textViewContactInformation=design.findViewById(R.id.textViewContactInformation)
            imageViewMore=design.findViewById(R.id.imageViewMore)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderCardDesign {
        val design = LayoutInflater.from(mContext).inflate(R.layout.contact_card_design,parent,false)
        return HolderCardDesign(design)
    }

    override fun onBindViewHolder(holder: HolderCardDesign, position: Int) {
        val contact = contactsList.get(position)

        holder.textViewContactInformation.text="${contact.contact_name}-${contact.contact_phone}"

        holder.imageViewMore.setOnClickListener{
            val popupMenu = PopupMenu(mContext,holder.imageViewMore)
            popupMenu.menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId){
                    R.id.action_delete->{
                        Snackbar.make(holder.imageViewMore,"Do you want to delete ${contact.contact_name}",Snackbar.LENGTH_SHORT)
                            .setAction("Yes"){

                                refContacts.child(contact.contact_id!!).removeValue()

                            }.show()
                        true
                    }
                    R.id.action_update->{
                        alertShow(contact)
                        true
                    }
                    else -> false
                }
            }

            popupMenu.show()
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    fun alertShow(contact:Contacts){
        val design = LayoutInflater.from(mContext).inflate(R.layout.alert_design,null)
        val editTextAlertName = design.findViewById(R.id.editTextAlertName) as EditText
        val editTextAlertPhone = design.findViewById(R.id.editTextAlertPhone) as EditText

        editTextAlertName.setText(contact.contact_name)
        editTextAlertPhone.setText(contact.contact_phone)

        val alertDialog = AlertDialog.Builder(mContext)
        alertDialog.setTitle("Update Contact")
        alertDialog.setView(design)
        alertDialog.setPositiveButton("Update"){ dialogInterface, i->
            val contact_name = editTextAlertName.text.toString().trim()
            val contact_phone = editTextAlertPhone.text.toString().trim()

            val informations = HashMap<String,Any>()
            informations.put("contact_name",contact_name)
            informations.put("contact_phone",contact_phone)

            refContacts.child(contact.contact_id!!).updateChildren(informations)

            Toast.makeText(mContext,"$contact_name-$contact_phone", Toast.LENGTH_SHORT).show()
        }
        alertDialog.setNegativeButton("Cancel"){ dialogInterface, i->

        }
        alertDialog.create().show()
    }

}