package com.example.useroom

import androidx.room.*

@Dao
interface UsersDao {
    @Query("SELECT * FROM users")
    suspend fun allUser() : List<Users>

    @Insert
    suspend fun addUser(user:Users)

    @Update
    suspend fun updateUser(user:Users)

    @Delete
    suspend fun deleteUser(user:Users)
}