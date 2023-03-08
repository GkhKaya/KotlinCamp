package com.example.useretrofit
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class UsersResponse(@SerializedName("users")
    @Expose
    var users:List<Users>,
    @SerializedName("success")
    @Expose
    var success:Int) {
}