package com.example.contactappwithmvvm.data.entity

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Contacts(
                    var contact_id:String?="",
                    var contact_name:String?="",
                    var contact_phone:String?=""):java.io.Serializable {
}