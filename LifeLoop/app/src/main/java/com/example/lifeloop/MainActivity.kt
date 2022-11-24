package com.example.lifeloop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("onCrate","worked")
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart","worked")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume","worked")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onpause","worked")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStpo","worked")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy","worked")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("onRestart","worked")
    }
}