package com.example.whatsapp.chat

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.whatsapp.VMs.App.WhatsAppVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SpecificChatComp(model: WhatsAppVM, navControllerBig: NavController) {
    Scaffold(
        topBar = { TopChatBarComp(navControllerBig = navControllerBig)},
        bottomBar = {BottomChatBarComp(model)},
    ){

    }
}