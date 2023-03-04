package com.example.useretrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserdaoInterface {
    @POST("kotlincamp/delete_users.php")
    @FormUrlEncoded
    fun deleteUser(@Field("user_id")user_id:Int):Call<CRUDResponse>


    @POST("kotlincamp/insert_users.php")
    @FormUrlEncoded
    fun addUser(@Field("user_name")user_name:String
                ,@Field("user_phone")user_phone:String):Call<CRUDResponse>

    @POST("kotlincamp/update_users.php")
    @FormUrlEncoded
    fun updateUser(@Field("user_id")user_id:Int
                ,@Field("user_name")user_name:String
                ,@Field("user_phone")user_phone:String):Call<CRUDResponse>

    @GET("kotlincamp/all_users.php")
    fun allUsers():Call<UsersResponse>
}