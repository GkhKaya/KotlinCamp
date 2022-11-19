package com.example.useviewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.useviewbinding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var design:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.makeButton.setOnClickListener{
            Snackbar.make(it, "Hello", Snackbar.LENGTH_SHORT).show()
        }
    }
}