package com.example.graduationproject.retrofit

import com.example.graduationproject.data.entity.CRUDResponse
import com.example.graduationproject.data.entity.FoodsInCartResponse
import com.example.graduationproject.data.entity.FoodsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {

@GET("foods/getAllFoods.php")
suspend fun loadFoods() : FoodsResponse

@POST("foods/insertFood.php")
@FormUrlEncoded
suspend fun insertFood(@Field("name") name : String,
                      @Field("image") image: String,
                      @Field("price") price: Int,
                      @Field("category") category: String,
                      @Field("orderAmount") orderAmount : Int,
                      @Field("userName") userName: String) : CRUDResponse

@POST("foods/getFoodsCart.php")
@FormUrlEncoded
suspend fun loadFoodsInCart(@Field("userName") userName: String = "nazrin") : FoodsInCartResponse

@POST("foods/deleteFood.php")
@FormUrlEncoded
suspend fun deleteFoodInCart(@Field("cartId") cartId:Int,
                             @Field("userName") userName: String = "nazrin") : CRUDResponse

}