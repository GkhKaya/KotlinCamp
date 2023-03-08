package com.example.usefirebaserealtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()

        val refUsers = database.getReference("users")

//        val user = Users("Gizem",18)
//        refUsers.push().setValue(user)

        //refUsers.child("-NPiiHUgWGlGSywXBWcJ").removeValue()

//        val updateInfo = HashMap<String,Any>()
//        updateInfo["user_name"]="Gokhan New"
//        updateInfo["user_age"]="19"
//        refUsers.child("-NPihjWbqdRtkpb5tweD").updateChildren(updateInfo)

        refUsers.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                for(p in snapshot.children){

                    val user = p.getValue(Users::class.java)
                    if(user !=null){
                        val key = p.key
                        Log.e("*******************","****************")
                        Log.e("User key", key!!)
                        Log.e("User name", user.user_name!!)
                        Log.e("User age",user.user_age.toString())
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}