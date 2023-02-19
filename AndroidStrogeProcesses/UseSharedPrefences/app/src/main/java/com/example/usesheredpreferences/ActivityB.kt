package com.example.usesheredpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val sp = getSharedPreferences("Personal İnformation", Context.MODE_PRIVATE)

        val name = sp.getString("name","Empty Name")
        val age = sp.getInt("age",0)
        val height = sp.getFloat("height",0.0f)
        val isSingle = sp.getBoolean("isSingle",false)

        val list = sp.getStringSet("friendList",null)

        Log.e("name",name.toString())
        Log.e("age",age.toString())
        Log.e("height",height.toString())
        Log.e("isSingle?",isSingle.toString())

        if(list!=null){
            for(friends in list){
                Log.e("friend",friends)
            }
        }


    }
}