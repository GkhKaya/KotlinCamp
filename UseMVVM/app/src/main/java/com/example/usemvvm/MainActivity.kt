package com.example.usemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.usemvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var design :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this,R.layout.activity_main)

        design.result.text = "0"

        design.sumButton.setOnClickListener{
            val gotNumberOne = design.numberOne.text.toString()
            val gotNumberTwo =  design.numberTwo.text.toString()

            val numberOne = gotNumberOne.toInt()
            val numberTwo= gotNumberTwo.toInt()

            val sum = numberOne+numberTwo

            design.result.text = sum.toString()

        }
        design.multipliButton.setOnClickListener{
            val gotNumberOne =  design.numberOne.text.toString()
            val gotNumberTwo =  design.numberTwo.text.toString()

            val numberOne = gotNumberOne.toInt()
            val numberTwo= gotNumberTwo.toInt()

            val multipli = numberOne*numberTwo

            design.result.text =multipli.toString()
        }
    }




}