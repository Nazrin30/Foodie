package com.example.graduationproject.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.repository.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RegisterViewModel @Inject constructor(var foodsRepository: FoodsRepository) : ViewModel() {
    fun saveUser(username: String, email : String, password : String){
        CoroutineScope(Dispatchers.Main).launch {
            foodsRepository.saveUser(username, email, password)
        }
    }
}