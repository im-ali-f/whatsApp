package com.example.whatsapp.chat

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.whatsapp.VMs.App.WhatsAppVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SpecificChatComp(model: WhatsAppVM, navControllerBig: NavController) {
    Scaffold(
        topBar = { TopChatBarComp(navControllerBig = navControllerBig)},
        bottomBar = {},
    ){

    }
}