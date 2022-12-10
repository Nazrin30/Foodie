package com.example.graduationproject.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.repository.FoodsRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var foodsRepository: FoodsRepository) : ViewModel() {
    var foodList = MutableLiveData<List<Foods>>()
    var filteredFoodsList = MutableLiveData<List<Foods>>()

    var tempfoods = listOf<Foods>()

    //    var newList = MutableLiveData<List<Foods>>()
    var categoriesFilterList = MutableLiveData<List<Foods>>()

    init {
        loadFoods()
        Log.e("Working", "HomeViewModel is working")

    }

    fun loadFoods() {
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = foodsRepository.loadFoods()
            filteredFoodsList.value = foodList.value
//            categoriesFilterList.value = foodsRepository.loadFoods()
            Log.e("Working", foodList.value.toString())
        }
    }

    fun search(word: String) {
        var foodsList = filteredFoodsList.value
        val newList = arrayListOf<Foods>()
        newList.clear()
        if (word.isEmpty()) {
            loadFoods()
        } else {
            for (food in 0 until foodsList!!.size) {
                if (foodsList[food].name.contains(word)) {
                    newList.add(foodsList[food])
                }
            }

        }
        try {
            filteredFoodsList.value = newList
        } catch (e: Exception) {
        }

    }

    fun categoriesFilter(name: String) {
        if (name == "All") {
            loadFoods()
        } else {
            val categories = arrayListOf<Foods>()
            categories.clear()
            //foodList.value = listOf()
            //  loadFoods()
            foodList.value!!.forEach {
                if (it.category == name) {
                    Log.e("categoriesFilterEach", it.category)
                    categories.add(it)
                }
//                }
                filteredFoodsList.value = categories
                Log.e("categoriesFilter", name)
                Log.e("categoriesFilter", categories.toString())
                Log.e("categoriesFilter food", foodList.value.toString())
            }
        }
    }
}