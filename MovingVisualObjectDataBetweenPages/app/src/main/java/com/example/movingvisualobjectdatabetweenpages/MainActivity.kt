package com.example.movingvisualobjectdatabetweenpages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener{

            val receivedData = editTextInput.text.toString()

            val newIntent  = Intent(this@MainActivity,ActivityB::class.java )

            newIntent.putExtra("message",receivedData)

            startActivity(newIntent)

        }
    }
}