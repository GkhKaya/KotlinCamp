package com.example.togglebuttonswitchuse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch1.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                Log.e("Swtich","On")

            }else{
                Log.e("Switch","Off")
            }

        }

        toggleButton.setOnCheckedChangeListener { compoundButton, b ->
            if(b){
                Log.e("Toggle Button","On")

            }else{
                Log.e("Toggle Button","Off")
            }

        }

        button.setOnClickListener {
            val switchStatus =  switch1.isChecked
            val toggleButtonStatus =  toggleButton.isChecked

            Log.e("Switch Status",switchStatus.toString())
            Log.e("Toggle Button Status",toggleButtonStatus.toString())
        }


    }
}