package com.example.contactapp

import com.google.firebase.database.IgnoreExtraProperties
@IgnoreExtraProperties
data class Contacts(var contact_id:String?=""
            ,var contact_name:String?=""
            ,val contact_phone:String?="") {
}