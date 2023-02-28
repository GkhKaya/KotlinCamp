package com.example.checkchargelevelapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PerceiveChargeLevel: BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        Toast.makeText(context,"Your charge is   almost done :(",Toast.LENGTH_SHORT).show()
    }
}