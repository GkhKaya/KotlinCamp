package com.example.finishmethod

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_screen.*

class ActivityGameScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        finishButton.setOnClickListener{
            val intent = Intent(this@ActivityGameScreen,ActivityResult::class.java)

            finish()

            startActivity(intent)

        }

    }
}