package com.example.graduationproject.data.datasource

import com.example.graduationproject.data.entity.Users
import com.example.graduationproject.room.UsersDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersDatasource (var usersDao: UsersDao)  {

suspend fun saveUser(username: String, email : String, password : String){
        val newPerson = Users(0,username, email , password)
        usersDao.save(newPerson)
    }

suspend fun getUsername(email: String) : String =
    withContext(Dispatchers.IO){
        usersDao.getUsername(email)
    }



}