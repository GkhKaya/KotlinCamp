package com.example.checkchargelevelapp

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var perceiveChargeLevel: PerceiveChargeLevel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        perceiveChargeLevel = PerceiveChargeLevel()

    }

    override fun onResume() {
        super.onResume()

        val filter = IntentFilter()
        filter.addAction("android.intent.action.BATTERY_LOW")

        registerReceiver(perceiveChargeLevel,filter)
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(perceiveChargeLevel)
    }
}