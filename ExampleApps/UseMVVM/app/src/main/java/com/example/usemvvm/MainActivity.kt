package com.example.usemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult.text="0"

        buttonTotal.setOnClickListener{
            val requestNumberOne = editTextNumberOne.text.toString()
            val requestNumberTwo = editTextNumberTwo.text.toString()

            val numberOne = requestNumberOne.toInt()
            val numberTwo = requestNumberTwo.toInt()

            val total = numberOne+numberTwo
            textViewResult.text=total.toString()

        }
        buttonMultiply.setOnClickListener{
            val requestNumberOne = editTextNumberOne.text.toString()
            val requestNumberTwo = editTextNumberTwo.text.toString()

            val numberOne = requestNumberOne.toInt()
            val numberTwo = requestNumberTwo.toInt()

            val multiply = numberOne*numberTwo
            textViewResult.text=multiply.toString()
        }
    }
}