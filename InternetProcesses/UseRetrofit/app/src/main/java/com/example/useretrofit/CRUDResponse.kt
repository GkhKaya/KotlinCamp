package com.example.useretrofit
import android.telephony.SmsMessage
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
class CRUDResponse(@SerializedName("success")
@Expose
var success:Int,
@SerializedName("message")
@Expose
var message: String) {
}