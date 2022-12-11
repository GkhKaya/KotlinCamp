package com.example.progressbarsliderratingbaruse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart.setOnClickListener {
            progressBar.visibility = View.VISIBLE
        }

        buttonStop.setOnClickListener {
            progressBar.visibility = View.INVISIBLE
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textViewResult.text="Result: $p1"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        } )

        buttonShow.setOnClickListener {
            val incomingProgress =  seekBar.progress
            val incomingVote =  ratingBar.rating

            Log.e("Progress : ",incomingProgress.toString())
            Log.e("Rating : ",incomingVote.toString())
        }
    }
}