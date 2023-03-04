package com.example.usefirebaserealtimedatabase

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Users(var user_name:String? = "", var user_age:Int?=0) {
}