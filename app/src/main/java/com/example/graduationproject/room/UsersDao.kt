package com.example.graduationproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.graduationproject.data.entity.Users

@Dao
interface UsersDao {

@Insert
suspend fun save(users: Users)


@Query("SELECT username FROM Users WHERE email like '%' || :email || '%'")
suspend fun getUsername(email:String) : String
}