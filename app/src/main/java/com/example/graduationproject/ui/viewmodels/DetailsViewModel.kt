package com.example.graduationproject.ui.viewmodels

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
class DetailsViewModel @Inject constructor(var foodsRepository: FoodsRepository) :ViewModel() {

    val foodsInCart: MutableLiveData<List<FoodsInCart>> = MutableLiveData()

    init {

    }

    fun addToCart(name: String, image: String, price : Int, category:String,orderAmount : Int, userName : String){

        CoroutineScope(Dispatchers.Main).launch {
                foodsRepository.addToCart(name, image,price,category,orderAmount,userName )
        }

    }

    fun getFoodsInCart() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val tempFoodsInCart = foodsRepository.loadFoodsInCart("nazrin")
                foodsInCart.postValue(tempFoodsInCart)
            }catch (e:Exception){}

        }
    }

    fun deleteFoodFromCart (cartId: Int, userName: String){
        CoroutineScope(Dispatchers.Main).launch {
            foodsRepository.deleteFoodInCart(cartId, userName)
        }
    }
}