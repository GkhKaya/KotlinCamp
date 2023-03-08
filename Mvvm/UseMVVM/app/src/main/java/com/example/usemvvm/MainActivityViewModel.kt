package com.example.usemvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var result = MutableLiveData<String>()
    var mrepo = MathRepository()

    init{
        result = mrepo.mathematicalResult
    }

    fun totalUp(requestNumberOne:String,requestNumberTwo:String){
        mrepo.total(requestNumberOne,requestNumberTwo)
    }
    fun doMultiply(requestNumberOne:String,requestNumberTwo:String){
        mrepo.multiply(requestNumberOne,requestNumberTwo)
    }
}