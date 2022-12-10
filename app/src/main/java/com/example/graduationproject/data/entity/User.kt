package com.example.graduationproject.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Users")
data class
Users (@PrimaryKey(autoGenerate = true)
                   @ColumnInfo(name = "id") @NotNull var id:Int,
                   @ColumnInfo(name = "username")@NotNull var username : String,
                   @ColumnInfo(name = "email")@NotNull var email : String,
                   @ColumnInfo(name = "password")@NotNull var password : String) : java.io.Serializable{
}