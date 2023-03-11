package com.example.useroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var db : MyDatabase
    private lateinit var usersDao: UsersDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MyDatabase.myDatabaseAccess(this)!!
        usersDao=db.getUsersDao()

        deleteUser()
        loadUsers()
    }

    fun loadUsers(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val outputList = usersDao.allUser()

            for (u in outputList){
                Log.e("User Id",u.user_id.toString())
                Log.e("User name",u.user_name.toString())
            }
        }
    }

    fun addUser(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newUser = Users(0,"Gokh2an",19)
            usersDao.addUser(newUser)


        }
    }

    fun updateUser(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedUser = Users(1,"Gokh3an",29)
            usersDao.updateUser(updatedUser)


        }
    }
    fun deleteUser(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedUser = Users(2,"erkut",19)
            usersDao.updateUser(deletedUser)


        }
    }
}