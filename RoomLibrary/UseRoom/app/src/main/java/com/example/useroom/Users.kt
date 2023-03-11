package com.example.useroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "users")
data class Users(@PrimaryKey(autoGenerate = true)
                 @ColumnInfo(name =  "user_id") @NotNull var user_id:Int,
                 @ColumnInfo(name =  "user_name") @NotNull var user_name:String,
                 @ColumnInfo(name =  "user_age") @NotNull var user_age:Int) {
}