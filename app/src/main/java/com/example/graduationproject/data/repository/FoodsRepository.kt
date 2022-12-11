package com.example.graduationproject.data.repository

import com.example.graduationproject.data.datasource.FoodsDatasource

import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsInCart

class FoodsRepository(var foodsDatasource: FoodsDatasource) {
    suspend fun loadFoods() : List<Foods> = foodsDatasource.loadFoods()

    suspend fun addToCart(name: String, image: String, price : Int, category:String,orderAmount : Int, userName : String) =
        foodsDatasource.addToCart(name,image, price, category, orderAmount,userName)

    suspend fun loadFoodsInCart(userName: String) : List<FoodsInCart> = foodsDatasource.loadFoodsInCart(userName)
    suspend fun deleteFoodInCart(cartId :Int, userName: String) = foodsDatasource.deleteFoodInCart(cartId, userName)


}