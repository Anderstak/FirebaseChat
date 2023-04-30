package com.example.firebasechat.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasechat.firebase.GetUsers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private var _isLoad = mutableStateOf(false)
    val isLoad
        get() = _isLoad

    init{
        getUsers()
    }

    //Список пользователей
    val users : MutableState<List<UserModel>> = mutableStateOf(listOf(UserModel()))

    fun getUsers(){
        viewModelScope.launch {
            _isLoad.value = true
            withContext(Dispatchers.IO){
                Thread.sleep(2000)
            }
            users.value = GetUsers()
            _isLoad.value = false
        }
    }
}