package com.example.useretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //deleteUser()
        //addUser()
        //updateUser()
        allUsers()

    }
    fun deleteUser(){
        val userdaoInterface=ApiUtils.getUsersDaoInterface()

        userdaoInterface.deleteUser(4).enqueue(object :Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                if(response!=null){
                    Log.e("Success",response.body()?.success.toString())
                    Log.e("Message", response.body()!!.message )
                }
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }
        })
    }

    fun addUser(){
        val userdaoInterface=ApiUtils.getUsersDaoInterface()

        userdaoInterface.addUser("Oktay","4454546").enqueue(object :Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                if(response!=null){
                    Log.e("Success",response.body()?.success.toString())
                    Log.e("Message", response.body()!!.message )
                }
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }
        })
    }

    fun updateUser(){
        val userdaoInterface=ApiUtils.getUsersDaoInterface()

        userdaoInterface.updateUser(5,"OktayNew","445454678").enqueue(object :Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                if(response!=null){
                    Log.e("Success",response.body()?.success.toString())
                    Log.e("Message", response.body()!!.message )
                }
            }

            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }
        })
    }

    fun allUsers(){
        val userdaoInterface=ApiUtils.getUsersDaoInterface()

        userdaoInterface.allUsers().enqueue(object :Callback<UsersResponse>{
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                if(response!=null){
                    val usersList = response.body()?.users

                    for (u in usersList!!){
                        Log.e("***********","*********")
                        Log.e("User id",u.userId.toString())
                        Log.e("User name",u.userName)
                        Log.e("User phone",u.userPhone)
                    }
                }
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}