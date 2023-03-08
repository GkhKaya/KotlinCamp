package com.example.dictionaryapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

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

        allWords()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        searchWords(query)
        search(query)
        Log.e("Sended searh", query.toString())

        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        searchWords(newText)
        search(newText)
        Log.e("Write letter", newText.toString())
        return true
    }

    fun allWords(){

        val url = "https://gkhkaya.com/kotlincamp/tum_kelimeler.php"
        val stringRequest = StringRequest(Request.Method.GET, url,Response.Listener { result ->
            wordsList = ArrayList()

            try {
                val jsonObject=JSONObject(result)
                val words = jsonObject.getJSONArray("words")
                for(i in 0 until words.length() ){
                    val w = words.getJSONObject(i)

                    val word = Words(w.getInt("word_id")
                        ,w.getString("english")
                        ,w.getString("turkish"))

                    wordsList.add(word)
                }

                adapter = WordsAdapter(this@MainActivity,wordsList)
                rv.adapter = adapter
            }catch (e:java.lang.Exception){
               e.printStackTrace()
            }
        },Response.ErrorListener {  })
        Volley.newRequestQueue(this).add(stringRequest)
    }

    fun searchWords(searchedWord:String){

        val url = "https://gkhkaya.com/kotlincamp/kelime_ara.php"
        val stringRequest = object : StringRequest(Request.Method.POST, url,Response.Listener { result ->
            wordsList = ArrayList()

            try {
                val jsonObject=JSONObject(result)
                val words = jsonObject.getJSONArray("words")
                for(i in 0 until words.length() ){
                    val w = words.getJSONObject(i)

                    val word = Words(w.getInt("word_id")
                        ,w.getString("english")
                        ,w.getString("turkish"))

                    wordsList.add(word)
                }

                adapter = WordsAdapter(this@MainActivity,wordsList)
                rv.adapter = adapter
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
        },Response.ErrorListener {  }){
            override fun getParams(): MutableMap<String, String>? {
                val params = HashMap<String,String >()
                params["english"]=searchedWord
                return params
            }
        }
        Volley.newRequestQueue(this).add(stringRequest)
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