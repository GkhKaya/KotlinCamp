package com.example.usesheredpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("Personal İnformation", Context.MODE_PRIVATE)
        val editor = sp.edit()

        editor.putString("name","Gokhan")
        editor.putInt("age",18)
        editor.putFloat("height",1.73f)
        editor.putBoolean("isSingle",true)

        val friendList = HashSet<String>()
        friendList.add("Gokhan2")
        friendList.add("Gokhan3")
        friendList.add("Gokhan4")

        editor.putStringSet("friendList",friendList)

        editor.commit()

        buttonGo.setOnClickListener {
            startActivity(Intent(this@MainActivity, ActivityB::class.java))
        }


    }
}