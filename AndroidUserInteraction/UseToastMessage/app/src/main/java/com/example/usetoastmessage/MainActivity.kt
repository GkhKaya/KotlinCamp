package com.example.usetoastmessage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNormal.setOnClickListener{
            Toast.makeText(applicationContext,"Hello",Toast.LENGTH_SHORT).show()
        }

        buttonSpecial.setOnClickListener{
            val design = layoutInflater.inflate(R.layout.toast_design,null)

            val textViewMessage = design.findViewById(R.id.textViewMessage) as TextView

            textViewMessage.text ="Hello special message"

            val toastSpecial = Toast(applicationContext)

            toastSpecial.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL,0,0)

            toastSpecial.duration = Toast.LENGTH_LONG

            toastSpecial.show()


        }

    }
}