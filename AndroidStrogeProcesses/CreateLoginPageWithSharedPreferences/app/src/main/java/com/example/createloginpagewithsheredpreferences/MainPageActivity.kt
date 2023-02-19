package com.example.createloginpagewithsheredpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val sp = getSharedPreferences("Loginİnformation", Context.MODE_PRIVATE)
        val usernameInformation = sp.getString("username","Empty Name")
        val passwordInformation = sp.getString("password","empty password")

        textViewOutput.text = "Username : $usernameInformation Password:$passwordInformation"

        buttonLogOut.setOnClickListener {

            val editor = sp.edit()
            editor.remove("username")
            editor.remove("password")
            editor.commit()

            startActivity(Intent(this@MainPageActivity, MainActivity::class.java))
            finish()
        }
    }
}