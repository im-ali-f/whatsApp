package com.example.whatsapp.VMs.App

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.whatsapp.VMs.API.MainViewModel
import com.example.whatsapp.VMs.API.UserInfoResponseListItem
import com.google.gson.Gson
import com.tinder.scarlet.Message
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.WebSocket.Event.OnConnectionClosed
import com.tinder.scarlet.WebSocket.Event.OnConnectionClosing
import com.tinder.scarlet.WebSocket.Event.OnConnectionFailed
import com.tinder.scarlet.WebSocket.Event.OnConnectionOpened
import com.tinder.scarlet.WebSocket.Event.OnMessageReceived
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import okhttp3.OkHttpClient

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

/*
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

 */

    fun SendMessage() {
        val message = message()
        if (message.message.isEmpty()) return
        chatService.sendMessage(message.toJsonString())

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

    private fun message(): ChatMessage {
        return _uiState.value?.let {
            ChatMessage(message = enteredChat.value, fromUserId = "Ali farhad")
        } ?: ChatMessage("", "")
    }


    //socket

    private val _uiState = MutableLiveData(ChatScreenUiState())
    val uiState: LiveData<ChatScreenUiState> = _uiState

    private var chatService: ChatService = Scarlet.Builder()
        .webSocketFactory(
            OkHttpClient.Builder().build()
                .newWebSocketFactory("wss://free.blr2.piesocket.com/v3/1?api_key=cuHKVqbaT5wdSrxVfeVydIV8TIexO2aYcqVKpTOD&notify_self=1")
        )
        .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
        .build().create<ChatService>()

    init {
        observerConnection()
    }

    private fun observerConnection() {
        Log.d("TAG", "Observing Connection")
        updateConnectionStatus(ConnectionStatus.CONNECTING)
        chatService.observeConnection().subscribe(
            { response ->
                Log.d("TAG", response.toString())
                onResponseReceived(response)
            },
            { error ->
                error.localizedMessage?.let { Log.e("TAG", it) }
            })
    }
    private fun onResponseReceived(response: WebSocket.Event) {
        when (response) {
            is OnConnectionOpened<*> ->
                updateConnectionStatus(ConnectionStatus.OPENED)

            is OnConnectionClosed ->
                updateConnectionStatus(ConnectionStatus.CLOSED)

            is OnConnectionClosing ->
                updateConnectionStatus(ConnectionStatus.CLOSING)

            is OnConnectionFailed ->
                updateConnectionStatus(ConnectionStatus.FAILED)

            is OnMessageReceived ->
                handleOnMessageReceived(response.message)
        }
    }
    private fun updateConnectionStatus(connectionStatus: ConnectionStatus) {
        _uiState.postValue(_uiState.value?.copy(connectionStatus = connectionStatus))
    }
    private fun handleOnMessageReceived(message: Message) {
        Log.d("TAG", "handleOnMessageReceived: $message")
        try {
            val value = (message as Message.Text).value
            val chatMessage = Gson().fromJson(value, ChatMessage::class.java)
            if (chatMessage.fromUserId != null && chatMessage.fromUserId != "Ali farhad") {
                val mapToSend = mutableMapOf(
                    "sender" to "${chatMessage.fromUserId}",
                    "sendDate" to "11/11/2011",
                    "sendTime" to "11:11",
                    "editDate" to "12/11/2011",
                    "editTime" to "12:12",
                    "text" to "${chatMessage.message}",
                    "type" to "receive",
                    "haveTail" to "true",
                )
                chatList.value[chatList.value.lastIndex]["haveTail"] = "false"
                chatList.value = chatList.value.plus(mapToSend)
                enteredChat.value = ""

            }
        } catch (e: Exception) {
            Log.e("TAG", "handleOnMessageReceived: ", e)
        }
    }


}





data class ChatMessage(
    val message: String,
    val fromUserId: String
)

fun ChatMessage.toJsonString(): String = Gson().toJson(this).toString()

data class ChatScreenUiState(
    var messages: List<ChatMessage> = listOf(),
    val userId: String = "",
    val message: String = "",
    val connectionStatus: ConnectionStatus = ConnectionStatus.NOT_STARTED
)
interface ChatService {

    @Receive
    fun observeConnection(): Flowable<WebSocket.Event>

    @Send
    fun sendMessage(message: String)

}
enum class ConnectionStatus {
    NOT_STARTED, OPENED, CLOSED, CONNECTING, CLOSING, FAILED, RECEIVED
}