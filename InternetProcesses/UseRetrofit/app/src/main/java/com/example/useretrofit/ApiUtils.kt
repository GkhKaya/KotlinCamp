package com.example.useretrofit

class ApiUtils {

    companion object{
        val BASE_URL = "https://gkhkaya.com/"

        fun getUsersDaoInterface():UserdaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(UserdaoInterface::class.java)
        }
    }
}