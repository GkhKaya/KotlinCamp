package com.example.guessnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getBooleanExtra("result",false)

        if (result){
            textViewResult.text= "Won"
            imageViewResult.setImageResource(R.drawable.happy_image)
        }else{
            textViewResult.text= "Lost"
            imageViewResult.setImageResource(R.drawable.sad_image)
        }


        buttonRestart.setOnClickListener{

            val intent = Intent(this@ResultActivity,MainActivity::class.java)

            finish()

            startActivity(intent)
        }
    }
}