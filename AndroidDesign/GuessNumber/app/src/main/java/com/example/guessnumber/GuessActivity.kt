package com.example.guessnumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_guess.*
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {

    private var randomNumber = 0
    private var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)

        randomNumber = Random.nextInt(101)
        Log.e("Random number",randomNumber.toString())

        buttonGuess.setOnClickListener{


            counter = counter-1

            val guess = editTextGuessArea.text.toString().toInt()

            if(guess==randomNumber){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("result",true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }

            if(guess>randomNumber){
                textViewHelper.text = "decrease"
                textViewPredictionNumber.text = "Predection Number : $counter"
            }
            if(guess<randomNumber){
                textViewHelper.text = "increase"
                textViewPredictionNumber.text = "Predection Number : $counter"
            }
            if(counter==0){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("result",false)
                finish()
                startActivity(intent)
            }

            editTextGuessArea.setText("")



        }
    }
}