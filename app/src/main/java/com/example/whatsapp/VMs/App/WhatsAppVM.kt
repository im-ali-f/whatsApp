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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WhatsAppVM(
    private val mainViewModel: MainViewModel,
    private val owner: LifecycleOwner,
    private val navController: NavController
) : ViewModel() {

    val canContinue = mutableStateOf(false)
    val userpassError = mutableStateOf(false)
    val enteredName = mutableStateOf("")
    val enteredPass = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)
    val loggedInUser = mutableStateOf(
        UserInfoResponseListItem(
            bio = "",
            phone = "",
            role = "",
            id = "",
            password = "",
            name = ""
        )
    )

    fun lsFunctionallity() {
        mainViewModel.GetUsersList()
        var userExistance = false
        mainViewModel.viewModelGetUsersListResponse.observe(owner, Observer { response ->
            if (response.isSuccessful) {

                Log.d("SuccessfulResponse", response.body().toString())
                response.body()?.forEach { item ->
                    if (item.name == enteredName.value) {
                        userExistance = true
                        if (item.password == enteredPass.value) {
                            loggedInUser.value = item
                            navigateToHome()
                        }
                    }
                }
                if (!userExistance) {
                    CreateUser()
                } else {
                    userpassError.value = true
                }
                mainViewModel.viewModelGetUsersListResponse = MutableLiveData()

            } else {
                Log.d("errorResponse", response.errorBody()?.string() as String)
            }
        })
    }

    fun CreateUser() {
        val bodyToSendAPI = UserInfoResponseListItem(
            name = enteredName.value,
            password = enteredPass.value,
            id = "",
            role = "member",
            phone = "",
            bio = ""
        )
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

    fun checkToContinue() {
        if (enteredPass.value != "" && enteredName.value != "") {
            canContinue.value = true
        } else {
            canContinue.value = false
        }
    }

    fun navigateToHome() {
        if (loggedInUser.value.name != "") {
            navController.navigate("homePage")
        }
    }


    //homepage
    val selectedBottomBar = mutableStateOf(0)

    //chat page
    val enteredChat = mutableStateOf("")

    val chatList = mutableStateOf(
        listOf(
            mutableMapOf(
                "sender" to "Ali farhad",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "Welcome To Chat !",
                "type" to "send",
                "haveTail" to "false",
            ),
            mutableMapOf(
                "sender" to "Ali farhad",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "try to chat with me!",
                "type" to "send",
                "haveTail" to "true",
            ),
            mutableMapOf(
                "sender" to "ADMIN",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "trying empty",
                "type" to "receive",
                "haveTail" to "false",

                ),
            mutableMapOf(
                "sender" to "ADMIN",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "",
                "type" to "receive",
                "haveTail" to "true",
            ),
            mutableMapOf(
                "sender" to "Ali farhad",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "trying big one !",
                "type" to "send",
                "haveTail" to "false",
            ),
            mutableMapOf(
                "sender" to "Ali farhad",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",
                "type" to "send",
                "haveTail" to "true",
            ),
            mutableMapOf(
                "sender" to "ADMIN",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                        "\n" +
                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",
                "type" to "receive",
                "haveTail" to "true",
            ),
            mutableMapOf(
                "sender" to "Ali farhad",
                "sendDate" to "11/11/2011",
                "sendTime" to "11:11",
                "editDate" to "12/11/2011",
                "editTime" to "12:12",
                "text" to "Now ; your turn to chat with us !",
                "type" to "send",
                "haveTail" to "true",
            ),


            )
    )


    fun SendMessage() {
        val mapToSend = mutableMapOf(
            "sender" to "Ali farhad",
            "sendDate" to "11/11/2011",
            "sendTime" to "11:11",
            "editDate" to "12/11/2011",
            "editTime" to "12:12",
            "text" to "${enteredChat.value}",
            "type" to "send",
            "haveTail" to "true",
        )
        chatList.value[chatList.value.lastIndex]["haveTail"] = "false"
        chatList.value = chatList.value.plus(mapToSend)
        enteredChat.value = ""

    }

}