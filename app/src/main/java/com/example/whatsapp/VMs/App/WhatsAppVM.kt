package com.example.whatsapp.VMs.App

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.whatsapp.VMs.API.MainViewModel
import com.example.whatsapp.VMs.API.UserInfoResponseListItem

class WhatsAppVM(private val mainViewModel: MainViewModel ,private val owner: LifecycleOwner , private val navController: NavController):ViewModel() {

    val userName = mutableStateOf("")
    val userId = mutableStateOf("")
    val userRole = mutableStateOf("")
    val userPhone = mutableStateOf("")
    val userBio = mutableStateOf("")

    val canContinue = mutableStateOf(false)
    val userpassError = mutableStateOf(false)
    val enteredName = mutableStateOf("")
    val enteredPass = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)
    val loggedInUser = mutableStateOf(UserInfoResponseListItem(bio = "", phone = "", role = "", id = "", password = "", name = ""))

    fun lsFunctionallity() {
        mainViewModel.GetUsersList()
        var userExistance = false
        mainViewModel.viewModelGetUsersListResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("SuccessfulResponse", response.body().toString())
                response.body()?.forEach { item->
                    if(item.name == enteredName.value){
                        userExistance = true
                        if(item.password == enteredPass.value){
                            loggedInUser.value = item
                            navigateToHome()
                        }
                    }
                }
                if(!userExistance){
                    CreateUser()
                }
                else{
                    userpassError.value = true
                }
                mainViewModel.viewModelGetUsersListResponse = MutableLiveData()

            } else {
                Log.d("errorResponse", response.errorBody()?.string() as String)
            }
        })
    }

    fun CreateUser() {
        val bodyToSendAPI = UserInfoResponseListItem(name = enteredName.value, password = enteredPass.value, id = "", role = "member", phone = "", bio = "")
        mainViewModel.CreateUser(bodyToSendAPI)
        mainViewModel.viewModelCreateUserResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("SuccessfulResponse", response.body().toString())
                loggedInUser.value = response.body()!!
                navigateToHome()

                mainViewModel.viewModelCreateUserResponse = MutableLiveData()

            } else {
                Log.d("errorResponse", response.errorBody()?.string() as String)
            }
        })
    }

    fun checkToContinue(){
        if(enteredPass.value != "" && enteredName.value != ""){
            canContinue.value = true
        }
        else{
            canContinue.value = false
        }
    }

    fun navigateToHome(){
        if(loggedInUser.value.name != ""){
            navController.navigate("homePage")
        }
    }


    //homepage
    val selectedBottomBar = mutableStateOf(0)

    //chat page
    val enteredChat = mutableStateOf("")


}