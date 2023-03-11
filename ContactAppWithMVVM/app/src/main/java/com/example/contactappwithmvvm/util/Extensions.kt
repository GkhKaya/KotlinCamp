package com.example.contactappwithmvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.contactappwithmvvm.R

fun Navigation.doTransition(id:Int,it:View){
    findNavController(it).navigate(R.id.addContactTransition)
}

fun Navigation.doTransition(id:NavDirections,it:View){
    findNavController(it).navigate(R.id.addContactTransition)
}