package com.example.createloginpagewithsheredpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("Loginİnformation",Context.MODE_PRIVATE)

        val automaticLoginUsernameInformation = sp.getString("username","Empty Name")
        val automaticLoginPasswordInformation = sp.getString("password","empty password")

        if(automaticLoginUsernameInformation=="admin"&&automaticLoginPasswordInformation=="123"){
            startActivity(Intent(this@MainActivity, MainPageActivity::class.java))
            finish()
        }else{

        }

        buttonLogin.setOnClickListener {

            val usernameInformation = editTextUsername.text.toString()
            val passwordInformation = editTextPassword.text.toString()

            if (usernameInformation == "admin" && passwordInformation == "123"){

                val editor  =sp.edit()
                editor.putString("username",usernameInformation)
                editor.putString("password",passwordInformation)
                editor.commit()



                startActivity(Intent(this@MainActivity, MainPageActivity::class.java))
                finish()
        }else {
                Toast.makeText(applicationContext, "Wrong İnput", Toast.LENGTH_SHORT).show()
            }

        }

    }
}