package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm  =supportFragmentManager
        val ft = fm.beginTransaction()

        ft.add(R.id.fragment_hold1,FragmentFirst())
        ft.add(R.id.fragment_hold2,FragmentSecond)

    }
}

