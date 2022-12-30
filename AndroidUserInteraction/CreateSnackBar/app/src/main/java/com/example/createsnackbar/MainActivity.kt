package com.example.createsnackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNormal.setOnClickListener{ view ->
            Snackbar.make(view,"hello",Snackbar.LENGTH_SHORT).show()
        }

        buttonBack.setOnClickListener{ view ->
            Snackbar.make(view,"hello",Snackbar.LENGTH_SHORT)
                .setAction("YES"){ view ->
                    Snackbar.make(view,"Message Deleted",Snackbar.LENGTH_SHORT).show()
                }
                .show()


        }

        buttonPrivate.setOnClickListener { view ->
            val sb = Snackbar.make(view,"Don't have internet connection",Snackbar.LENGTH_SHORT)
            sb.setAction("Try again"){

            }
            sb.setActionTextColor(Color.RED)
            sb.setTextColor(Color.BLUE)
            sb.setBackgroundTint(Color.WHITE)
            sb.show()

        }

    }
}