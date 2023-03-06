package com.example.usemvvm

import androidx.lifecycle.MutableLiveData

class MathRepository {
    var mathematicalResult = MutableLiveData<String>()

    init{
        mathematicalResult = MutableLiveData<String>("0")
    }
    @JvmName("getMathematicalResult1")
    fun getMathematicalResult():MutableLiveData<String>{
        return mathematicalResult
    }

    fun total(requestNumberOne:String,requestNumberTwo:String){
        val numberOne = requestNumberOne.toInt()
        val numberTwo = requestNumberTwo.toInt()

        val total = numberOne+numberTwo

        mathematicalResult.value = total.toString()
    }
    fun multiply(requestNumberOne:String,requestNumberTwo:String){
        val numberOne = requestNumberOne.toInt()
        val numberTwo = requestNumberTwo.toInt()

        val total = numberOne*numberTwo

        mathematicalResult.value = total.toString()
    }
}