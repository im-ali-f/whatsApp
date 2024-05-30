package com.example.whatsapp.HomePage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.VMs.App.WhatsAppVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeComp(navController: NavController, model: WhatsAppVM) {
    Scaffold(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        topBar = {
            TopBarComp()
        },
        bottomBar = {
            BottmBarComp(model = model)
        },
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.White)
            ) {
                val navStatusInner = rememberNavController()
                NavHost(navController = navStatusInner, startDestination = "chatsPart") {
                    composable("chatsPart"){
                        ChatsComp(model = model , navStatusInner,navController)
                    }

                }
            }
        }


    )
}