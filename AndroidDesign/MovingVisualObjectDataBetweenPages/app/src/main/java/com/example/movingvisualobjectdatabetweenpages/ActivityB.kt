package com.example.movingvisualobjectdatabetweenpages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val incomingData = intent.getStringExtra("message")

        textViewOutput.text = incomingData

    }
}