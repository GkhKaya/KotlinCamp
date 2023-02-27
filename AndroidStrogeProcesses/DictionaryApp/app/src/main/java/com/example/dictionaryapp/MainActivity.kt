package com.example.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    private lateinit var wordsList: ArrayList<Words>
    private lateinit var adapter :WordsAdapter
    private lateinit var dh :DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        copyDatabase()

        toolbar.title="Dictionary App"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager=LinearLayoutManager(this)
        dh= DatabaseHelper(this)

        val wordsdao = Wordsdao()
        wordsList = wordsdao.tumKelimeler(dh)


        adapter = WordsAdapter(this,wordsList)

        rv.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        Log.e("Sended searh", query.toString())

        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        Log.e("Write letter", newText.toString())
        return true
    }

    fun copyDatabase(){
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

    fun search(searchedWord:String){
        val wordsdao = Wordsdao()
        wordsList = wordsdao.doSearch(dh,searchedWord)


        adapter = WordsAdapter(this,wordsList)

        rv.adapter = adapter

    }
}