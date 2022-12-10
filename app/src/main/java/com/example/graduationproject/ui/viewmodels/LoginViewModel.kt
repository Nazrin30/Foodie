package com.example.graduationproject.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduationproject.data.repository.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(var foodsRepository: FoodsRepository) : ViewModel() {
    var username = MutableLiveData<String>()
    fun getUsername(email:String){
        CoroutineScope(Dispatchers.Main).launch {
            username.value = foodsRepository.getUsername(email)
        }
    }
}