package com.example.usevideoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            val adresses = Uri.parse("android.resource://"+packageName+"/"+R.raw.video)
            videoView.setVideoURI(adresses)
            videoView.start()
        }
        buttonStop.setOnClickListener {
            videoView.stopPlayback()
        }
    }
}