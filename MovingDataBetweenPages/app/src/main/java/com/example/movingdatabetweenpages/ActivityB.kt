package com.example.movingdatabetweenpages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val incomingMessage = intent.getStringExtra("message")
        val incomingAge = intent.getIntExtra("age",0)
        val incomingHeight = intent.getDoubleExtra("height",0.0)

        Log.e("Message",incomingMessage.toString())
        Log.e("age", incomingAge.toString())
        Log.e("height",incomingHeight.toString())

        val incomingUser = intent.getSerializableExtra("subject") as Users

        Log.e("User's tc no", incomingUser.ıdentitiyNumber.toString())
        Log.e("User's name", incomingUser.name)
        Log.e("User's height", incomingUser.height.toString())

    }
}