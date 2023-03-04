package com.example.useretrofit
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class Users(
    @SerializedName("user_id")
    @Expose
    var userId:Int,
    @SerializedName("user_name")
    @Expose
    var userName:String,
    @SerializedName("user_phone")
    @Expose
    var userPhone:String){

}