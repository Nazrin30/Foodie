package com.example.graduationproject.data.entity

data class FoodsInCart(
    var cartId: Int,
    var name: String,
    var image: String,
    var price: Int,
    var category: String,
    var orderAmount: Int,
    var userName: String) : java.io.Serializable {

}