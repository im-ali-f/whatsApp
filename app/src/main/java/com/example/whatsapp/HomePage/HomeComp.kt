package com.example.whatsapp.HomePage

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.ui.theme.disabledText
import com.example.whatsapp.ui.theme.enabledText
import com.example.whatsapp.ui.theme.mainGray

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
                        ChatsComp(model = model , navController)
                    }
                    composable("specificChatPart"){
                        SpecificChatComp(model,navController)//remove she az inja
                    }
                }
            }
        }


    )
}