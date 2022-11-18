package com.example.usemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result.text = "0"

        sumButton.setOnClickListener{
            val gotNumberOne =  numberOne.text.toString()
            val gotNumberTwo =  numberTwo.text.toString()

            val numberOne = gotNumberOne.toInt()
            val numberTwo= gotNumberTwo.toInt()

            val sum = numberOne+numberTwo

            result.text = sum.toString()

        }
        multipliButton.setOnClickListener{
            val gotNumberOne =  numberOne.text.toString()
            val gotNumberTwo =  numberTwo.text.toString()

            val numberOne = gotNumberOne.toInt()
            val numberTwo= gotNumberTwo.toInt()

            val multipli = numberOne*numberTwo

            result.text = multipli.toString()
        }
    }




}