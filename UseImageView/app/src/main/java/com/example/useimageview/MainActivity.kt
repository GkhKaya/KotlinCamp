package com.example.useimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonImageOne.setOnClickListener {
            imageView.setImageResource(R.drawable.ic_baseline_adb_24)
        }

        buttonImageTwo.setOnClickListener {
            imageView.setImageResource(resources.getIdentifier("sgsdg","drawble",packageName))

        }
    }
}