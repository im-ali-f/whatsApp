package com.example.whatsapp.VMs.App

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.whatsapp.VMs.API.MainViewModel
import com.example.whatsapp.VMs.API.UserInfoResponseListItem

class WhatsAppVM(private val mainViewModel: MainViewModel ,private val owner: LifecycleOwner):ViewModel() {

    val userName = mutableStateOf("")
    val userId = mutableStateOf("")
    val userRole = mutableStateOf("")
    val userPhone = mutableStateOf("")
    val userBio = mutableStateOf("")

    val canContinue = mutableStateOf(false)
    val enteredName = mutableStateOf("")
    val enteredPass = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)

    fun GetUsersListResponser() {
        mainViewModel.GetUsersList()
        mainViewModel.viewModelGetUsersListResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("SuccessfulResponse", response.body().toString())

                mainViewModel.viewModelGetUsersListResponse = MutableLiveData()

            } else {
                Log.d("errorResponse", response.errorBody()?.string() as String)
            }
        })
    }

    fun CreateUserResponser() {
        val bodyToSendAPI = UserInfoResponseListItem(name = "aaa", password = "aaaa", id = "5", role = "admin", phone = "092221", bio = "hi")
        mainViewModel.CreateUser(bodyToSendAPI)
        mainViewModel.viewModelCreateUserResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("SuccessfulResponse", response.body().toString())

                mainViewModel.viewModelCreateUserResponse = MutableLiveData()

            } else {
                Log.d("errorResponse", response.errorBody()?.string() as String)
            }
        })
    }


}