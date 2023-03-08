package com.example.usesqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dh = DatabaseHelper(this)
        val usersdao=Usersdao()



        usersdao.deleteUsers(dh,2)








    }



}