package com.example.graduationproject.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.graduationproject.data.entity.Users

@Database(entities = [Users :: class], version = 1)
abstract class MyDatabase : RoomDatabase(){
    abstract fun getUsersDao() : UsersDao

}