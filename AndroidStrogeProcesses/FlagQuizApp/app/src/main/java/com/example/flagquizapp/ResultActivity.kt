package com.example.flagquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val trueCount = intent.getIntExtra("trueCount",0)

        textViewResult.text = "$trueCount True, ${5-trueCount} False"
        textViewPercantResult.text = "%${trueCount*20} Success"

        buttonRestart.setOnClickListener{
            startActivity(Intent(this@ResultActivity, QuizActivity::class.java))
            finish()
        }


    }
}