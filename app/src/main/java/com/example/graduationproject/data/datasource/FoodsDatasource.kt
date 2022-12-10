package com.example.graduationproject.data.datasource

import android.util.Log
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsInCart
import com.example.graduationproject.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDatasource (var foodsDao: FoodsDao) {
    suspend fun loadFoods() : List<Foods> =
        withContext(Dispatchers.IO){
            foodsDao.loadFoods().foods


        }
   suspend fun addToCart(name: String, image: String, price : Int, category:String,orderAmount : Int, userName : String) =
       foodsDao.insertFood(name,image, price, category, orderAmount, userName)

    suspend fun loadFoodsInCart(userName: String) : List<FoodsInCart> =

        withContext(Dispatchers.IO) {
            foodsDao.loadFoodsInCart(userName).foods_cart

        }
    suspend fun deleteFoodInCart(cartId :Int, userName: String) = foodsDao.deleteFoodInCart(cartId, userName)



    }