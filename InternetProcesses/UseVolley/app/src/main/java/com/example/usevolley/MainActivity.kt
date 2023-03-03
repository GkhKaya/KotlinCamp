package com.example.usevolley

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deleteUser()
        //addUser()
        //updateUser()
        //allUsers()
        allUserSearch()

    }

    private fun deleteUser(){


        val url = "https://gkhkaya.com/kotlincamp/delete_users.php"

        val request = object : StringRequest(Method.POST,url,Response.Listener { result ->
            Log.e("Delete Process Result",result)
        },Response.ErrorListener{error ->  error.printStackTrace()}){
            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()
                params["user_id"] = "2"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    private fun addUser(){
        val url="https://gkhkaya.com/kotlincamp/insert_users.php"
        val request = object : StringRequest(Method.POST,url,Response.Listener { result ->
            Log.e("Adding Process Result",result)
        },Response.ErrorListener{error ->  error.printStackTrace()}){
            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()
                params["user_name"] = "Oktay"
                params["user_phone"] = "124343"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    private fun updateUser(){
        val url = "https://gkhkaya.com/kotlincamp/update_users.php"
        val request = object : StringRequest(Method.POST,url,Response.Listener { result ->
            Log.e("Update Process Result",result)
        },Response.ErrorListener{error ->  error.printStackTrace()}){
            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()
                params["user_id"] = "1"
                params["user_name"] = "Gokhan3"
                params["user_phone"] = "156789"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    private fun allUsers(){
        val url = "https://gkhkaya.com/kotlincamp/all_users.php"
        val request =  StringRequest(Request.Method.GET,url,Response.Listener { result ->
            Log.e("Data Reading Response",result)

            try {
                val jsonObject = JSONObject(result)
                val userList = jsonObject.getJSONArray("users")

                for (i in 0 until userList.length()){
                    val u = userList.getJSONObject(i)
                    val user_id = u.getInt("user_id")
                    val user_name = u.getString("user_name")
                    val user_phone = u.getString("user_phone")

                    Log.e("user id",user_id.toString())
                    Log.e("user name",user_name.toString())
                    Log.e("user phone",user_phone.toString())
                    Log.e("*************","*************")

                }
            }catch (e:JSONException){
                e.printStackTrace()
            }

        },Response.ErrorListener{error ->  error.printStackTrace()})

        Volley.newRequestQueue(this@MainActivity).add(request)
    }

    private fun allUserSearch(){
        val url = "http://gkhkaya.com/kotlincamp/all_users_search.php"

        val request = object : StringRequest(Method.POST,url,Response.Listener { result ->
            Log.e("Search Result",result)

            try {
                val jsonObject = JSONObject(result)
                val userList = jsonObject.getJSONArray("users")

                for (i in 0 until userList.length()){
                    val u = userList.getJSONObject(i)
                    val user_id = u.getInt("user_id")
                    val user_name = u.getString("user_name")
                    val user_phone = u.getString("user_phone")

                    Log.e("user id",user_id.toString())
                    Log.e("user name",user_name.toString())
                    Log.e("user phone",user_phone.toString())
                    Log.e("*************","*************")

                }
            }catch (e:JSONException){
                e.printStackTrace()
            }
        },Response.ErrorListener{error ->  error.printStackTrace()}){
            override fun getParams(): MutableMap<String, String> {

                val params = HashMap<String,String>()
                params["user_name"] = "a"
                return params
            }
        }

        Volley.newRequestQueue(this@MainActivity).add(request)
    }
}