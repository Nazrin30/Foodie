package com.example.graduationproject.data.repository

import com.example.graduationproject.data.datasource.FoodsDatasource
import com.example.graduationproject.data.datasource.UsersDatasource
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsInCart

class FoodsRepository(var foodsDatasource: FoodsDatasource, var usersDatasource: UsersDatasource) {
    suspend fun loadFoods() : List<Foods> = foodsDatasource.loadFoods()

    suspend fun addToCart(name: String, image: String, price : Int, category:String,orderAmount : Int, userName : String) =
        foodsDatasource.addToCart(name,image, price, category, orderAmount,userName)

    suspend fun loadFoodsInCart(userName: String) : List<FoodsInCart> = foodsDatasource.loadFoodsInCart(userName)
    suspend fun deleteFoodInCart(cartId :Int, userName: String) = foodsDatasource.deleteFoodInCart(cartId, userName)

    suspend fun saveUser(username: String, email : String, password : String) =
        usersDatasource.saveUser(username, email, password)
    suspend fun getUsername(email: String) : String = usersDatasource.getUsername(email)
}