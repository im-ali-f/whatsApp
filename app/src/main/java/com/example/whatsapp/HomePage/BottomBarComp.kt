package com.example.whatsapp.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whatsapp.R
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.ui.theme.disabledText
import com.example.whatsapp.ui.theme.mainBlue

@Composable
fun BottmBarComp( model: WhatsAppVM) {

    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(bottom = 5.dp )
    ) {
        //sep
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(disabledText)
        )
        //end sep
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { model.selectedBottomBar.value = 1 },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(100),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {


                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.status),
                        tint = if (model.selectedBottomBar.value == 1) mainBlue else Color.Gray,
                        contentDescription = null
                    )

                }
                Text(
                    text = "Status",
                    fontWeight = FontWeight(500),
                    fontSize = 13.sp,
                    lineHeight = 27.sp,
                    color = if (model.selectedBottomBar.value == 1) mainBlue else Color.Gray,
                    textAlign = TextAlign.Center,
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { model.selectedBottomBar.value = 2 },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(100),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {


                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.calls),
                        tint = if (model.selectedBottomBar.value == 2) mainBlue else Color.Gray,
                        contentDescription = null
                    )

                }
                Text(
                    text = "Calls",
                    fontWeight = FontWeight(500),
                    fontSize = 13.sp,
                    lineHeight = 27.sp,
                    color = if (model.selectedBottomBar.value == 2) mainBlue else Color.Gray,
                    textAlign = TextAlign.Center,
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { model.selectedBottomBar.value = 3 },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(100),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {


                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.camera),
                        tint = if (model.selectedBottomBar.value == 3) mainBlue else Color.Gray,
                        contentDescription = null
                    )

                }
                Text(
                    text = "Camera",
                    fontWeight = FontWeight(500),
                    fontSize = 13.sp,
                    lineHeight = 27.sp,
                    color = if (model.selectedBottomBar.value == 3) mainBlue else Color.Gray,
                    textAlign = TextAlign.Center,
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { model.selectedBottomBar.value = 4 },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(100),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {


                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.chats),
                        tint = if (model.selectedBottomBar.value == 4) mainBlue else Color.Gray,
                        contentDescription = null
                    )

                }
                Text(
                    text = "Chats",
                    fontWeight = FontWeight(500),
                    fontSize = 13.sp,
                    lineHeight = 27.sp,
                    color = if (model.selectedBottomBar.value == 4) mainBlue else Color.Gray,
                    textAlign = TextAlign.Center,
                )
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { model.selectedBottomBar.value = 5 },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    contentPadding = PaddingValues(0.dp),
                    shape = RoundedCornerShape(100),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {


                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.settings),
                        tint = if (model.selectedBottomBar.value == 5) mainBlue else Color.Gray,
                        contentDescription = null
                    )

                }
                Text(
                    text = "Settings",
                    fontWeight = FontWeight(500),
                    fontSize = 13.sp,
                    lineHeight = 27.sp,
                    color = if (model.selectedBottomBar.value == 5) Color.Blue else Color.Gray,
                    textAlign = TextAlign.Center,
                )
            }


        }
    }

}