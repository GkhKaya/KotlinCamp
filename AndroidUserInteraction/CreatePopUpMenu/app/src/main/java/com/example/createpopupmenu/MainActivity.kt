package com.example.createpopupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOpenMenu.setOnClickListener{
            val popup = PopupMenu(this@MainActivity,buttonOpenMenu)
            popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when(item.itemId){
                    R.id.action_delete ->{
                        Toast.makeText(applicationContext,"Delete",Toast.LENGTH_SHORT).show()
                        true
                    }

                    R.id.action_edit -> {
                        Toast.makeText(applicationContext,"Edit",Toast.LENGTH_SHORT).show()
                        true
                    }

                    else -> false
                }
            }
            popup.show()
        }
    }
}