package com.example.radiobuttoncheckboxuse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val javaStatus = checkBoxJava.isChecked
            val kotlinStatus = checkBoxKotlin.isChecked
            val barcelonaStatus = radioButtonBarcelona.isChecked
            val realMadridStatus = radioButtonRealMadrid.isChecked

            Log.e("Java Status", javaStatus.toString())
            Log.e("Kotlin Status", kotlinStatus.toString())
            Log.e("Barcelona Status", barcelonaStatus.toString())
            Log.e("Real Madrid Status", realMadridStatus.toString())
        }

        radioButtonBarcelona.setOnCheckedChangeListener { compoundButton, b ->

            if(b){
                Toast.makeText(applicationContext,"Cong: ", Toast.LENGTH_SHORT).show()
            }

        }
    }
}