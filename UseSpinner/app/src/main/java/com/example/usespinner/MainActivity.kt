package com.example.usespinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val countries = ArrayList<String>()
    private  lateinit var  dataAdapter : ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countries.add("Turkiye")
        countries.add("Italy")
        countries.add("Japan")
        countries.add("China")
       countries.add("Paris")

        dataAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,countries)

        spinner.adapter = dataAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
                Toast.makeText(applicationContext, "Choosed Country : ${countries[index]}",Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        showButton.setOnClickListener{
            Toast.makeText(applicationContext, "Country : ${countries[spinner.selectedItemPosition]}",Toast.LENGTH_LONG).show()

        }

    }
}