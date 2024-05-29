package com.example.whatsapp.lsPage

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whatsapp.R
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.ui.theme.disabledText
import com.example.whatsapp.ui.theme.enabledText
import com.example.whatsapp.ui.theme.mainBlue
import com.example.whatsapp.ui.theme.mainGray
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Composable
fun LSComp(navController: NavController, model: WhatsAppVM) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(mainGray)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Phone number",
                    fontWeight = FontWeight(600),
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,

                    )

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.5.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { model.lsFunctionallity() }
                            .padding(5.dp),
                        text = "Done",
                        fontWeight = FontWeight(600),
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center,
                        color = if (model.canContinue.value) enabledText else disabledText
                    )
                }


            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 38.dp, end = 38.dp, bottom = 20.dp, top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "Please confirm your country code and enter your phone number ",
                    fontWeight = FontWeight(400),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black

                )
            }

            //sep
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(disabledText)
            )
            //end sep
            Box(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = model.enteredName.value,
                    onValueChange = { new ->
                        model.enteredName.value = new
                        model.checkToContinue()
                    },
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 26.sp, fontWeight = FontWeight(500)),
                    placeholder = {
                        Text(
                            text = "name",
                            fontWeight = FontWeight(300),
                            fontSize = 23.sp,
                            color = disabledText

                        )
                    },

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = mainBlue,
                        unfocusedContainerColor = Color.White,
                    ),
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),

                    )
            }

            //sep
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(disabledText)
            )
            //end sep


            Box(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = model.enteredPass.value,
                    onValueChange = { new ->
                        model.enteredPass.value = new
                        model.checkToContinue()
                    },
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxWidth(),
                    textStyle = TextStyle(fontSize = 26.sp, fontWeight = FontWeight(500)),
                    placeholder = {
                        Text(
                            text = "password",
                            fontWeight = FontWeight(300),
                            fontSize = 23.sp,
                            color = disabledText

                        )
                    },

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = mainBlue,
                        unfocusedContainerColor = Color.White,
                    ),
                    visualTransformation = if (model.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            model.passwordVisible.value = !model.passwordVisible.value
                        }) {
                            Icon(
                                painter = painterResource(id = if (model.passwordVisible.value) R.drawable.eye_slash else R.drawable.eye),
                                modifier = Modifier.size(19.dp),
                                contentDescription = " toggle pass word Icon",
                                tint = Color.Black
                            )
                        }
                    },
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),

                    )
            }

            //sep
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(disabledText)
            )
            //end sep
        }

        val animateOffset by animateIntAsState(
            targetValue = if (model.userpassError.value) 0 else -50,
            animationSpec = tween(
                durationMillis = 500,
            ), label = "erroranimation"
        )
                LaunchedEffect(model.userpassError.value) {
                    delay(2500).apply {
                        model.userpassError.value = false
                    }

                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .offset(y = -animateOffset.dp)
                        .background(mainGray)
                        .align(Alignment.BottomCenter),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "password or username invalid",
                        fontWeight = FontWeight(600),
                        fontSize = 17.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Red,
                    )
                }




    }
}