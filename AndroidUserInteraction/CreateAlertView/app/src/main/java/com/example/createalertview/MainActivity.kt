package com.example.createalertview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNormal.setOnClickListener{
            val ad = AlertDialog.Builder(this@MainActivity)

            ad.setMessage("Message")
            ad.setTitle("Title")
            ad.setIcon(R.drawable.mage)

            ad.setPositiveButton("Okey"){
                dialogInterface, i ->
                Toast.makeText(applicationContext,"Okey Touched",Toast.LENGTH_SHORT).show()
            }

            ad.setNegativeButton("Cancel"){
                    dialogInterface, i ->
                Toast.makeText(applicationContext,"Cancel Touched",Toast.LENGTH_SHORT).show()
            }

            ad.create().show()

        }
        buttonPrivate.setOnClickListener{
            val design = layoutInflater.inflate(R.layout.alert_design,null)
            val ad = AlertDialog.Builder(this@MainActivity)

            ad.setMessage("Message")
            ad.setTitle("Title")
            ad.setIcon(R.drawable.mage)

            ad.setPositiveButton("Save"){
                    dialogInterface, i ->
                Toast.makeText(applicationContext,"Save Touched",Toast.LENGTH_SHORT).show()
            }

            ad.setNegativeButton("Cancel"){
                    dialogInterface, i ->
                Toast.makeText(applicationContext,"Cancel Touched",Toast.LENGTH_SHORT).show()
            }

            ad.create().show()
        }
    }
}