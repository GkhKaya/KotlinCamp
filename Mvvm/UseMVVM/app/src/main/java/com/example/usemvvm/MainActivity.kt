package com.example.usemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.usemvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var design:ActivityMainBinding
    private val viewModel:MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this,R.layout.activity_main)
        design.mainActivityObject=this


        viewModel.result.observe(this,{ r ->
            design.calculateResult=r
        })



    }

    fun buttonTotalClick(requestNumberOne:String,requestNumberTwo:String){
        viewModel.totalUp(requestNumberOne,requestNumberTwo)


    }

    fun buttonMultiplyClick(requestNumberOne:String,requestNumberTwo:String){
        viewModel.doMultiply(requestNumberOne,requestNumberTwo)


    }
}