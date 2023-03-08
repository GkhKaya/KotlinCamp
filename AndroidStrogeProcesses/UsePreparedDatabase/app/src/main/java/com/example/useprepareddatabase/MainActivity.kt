package com.example.useprepareddatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyDatabase()

        val dh = DatabaseHelper(this)

        val list = Kategorilerdao().getAllCategories(dh)

        for (c in list){
            Log.e("Kategori id",(c.kategori_id).toString())
            Log.e("Kategori Ad",(c.kategori_ad))
        }
    }


    fun copyDatabase(){
        val db = DatabaseCopyHelper(this)



        try {
            db.createDataBase()
        }catch(e:java.lang.Exception){
            e.printStackTrace()
        }

        try {
            db.openDataBase()
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }
}