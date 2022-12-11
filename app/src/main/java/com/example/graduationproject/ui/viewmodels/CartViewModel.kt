package com.example.graduationproject.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.entity.FoodsInCart
import com.example.graduationproject.data.repository.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(var foodsRepository: FoodsRepository) : ViewModel() {

    var userName = MutableLiveData<String>()
   var foodsInCart = MutableLiveData<List<FoodsInCart>>()
    //var totalAmount = MutableLiveData<Int>()
    private var  mutableTotalPrice =  MutableLiveData<Int>( )
    init  {
        loadFoodsInCart("nazrin")
        calculateTotal()
    }
    fun loadFoodsInCart(userName : String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                foodsInCart.value = foodsRepository.loadFoodsInCart(userName)
                calculateTotal()
            }catch (e:Exception){
                foodsInCart.value = listOf()
               Log.e("cartViewModel", e.toString())
            }
        }
    }

    fun deleteFoodInCart(cartId:Int, userName: String){
        CoroutineScope(Dispatchers.Main).launch {
            foodsRepository.deleteFoodInCart(cartId, userName)
           // Log.e("username", this.userName)
            loadFoodsInCart("nazrin")
        }
        calculateTotal()
    }

    fun increaseAmountInCart(name: String, image: String,
                             price : Int, category:String,
                             orderAmount : Int, userName : String){
        CoroutineScope(Dispatchers.Main).launch {
            foodsRepository.addToCart(name, image, price, category, orderAmount, userName)
        }

    }

    fun getTotalPrice() : LiveData<Int>{
        if(mutableTotalPrice.value == null){
            mutableTotalPrice.value = 0
        }
        return mutableTotalPrice
    }
    fun calculateTotal(){
        if (foodsInCart.value == null) return
        var total = 0
        var cartItemList = foodsInCart.value
        for (cartItem in 0 until cartItemList!!.size){
             total += cartItemList[cartItem].price * cartItemList[cartItem].orderAmount
        }
        mutableTotalPrice.value = total
    }


}