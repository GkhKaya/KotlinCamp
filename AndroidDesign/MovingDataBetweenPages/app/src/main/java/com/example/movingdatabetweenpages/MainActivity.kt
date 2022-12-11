package com.example.movingdatabetweenpages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend.setOnClickListener{

            val user =  Users(12345678,"Gokhan",1.78)

            val newIntent = Intent(this@MainActivity,ActivityB::class.java)

            newIntent.putExtra("message", "message")
            newIntent.putExtra("age", "23")
            newIntent.putExtra("height", "1.78")
            newIntent.putExtra("object", user)
            startActivity(newIntent)
        }
    }
}