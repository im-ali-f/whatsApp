package com.example.whatsapp.chat

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.ui.theme.bottomBarBGColor
import com.example.whatsapp.ui.theme.chatBorderColor
import com.example.whatsapp.ui.theme.disabledText
import com.example.whatsapp.ui.theme.mainBlue

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomChatBarComp(model:WhatsAppVM) {

    val animatedBox by animateFloatAsState(
        targetValue = if (model.enteredChat.value == "") 0.7f else 0.87f,
        animationSpec = tween(
            durationMillis = 300
        ),
        label = "box animation"
    )



    Box(
        Modifier
            .fillMaxWidth()
            .background(bottomBarBGColor)
            .padding(bottom = 5.dp)
            .imePadding()
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
            Modifier
                .fillMaxWidth()
                .padding(top = 7.dp),
            //verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(modifier = Modifier.align(Alignment.Bottom), onClick = { }) {
                Icon(
                    painter = painterResource(id = R.drawable.plus),
                    modifier = Modifier.size(22.dp),
                    contentDescription = "Icon",
                    tint = mainBlue
                )
            }
            //input part
            Box(
                modifier = Modifier
                    .fillMaxWidth(animatedBox)
                    //.height(40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .border(0.7.dp, chatBorderColor, RoundedCornerShape(20.dp))
                    .padding(start = 10.dp)
            ){
                IconButton(modifier = Modifier.align(Alignment.BottomEnd),onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.stickers),
                        modifier = Modifier.size(20.dp),
                        contentDescription = "Icon",
                        tint = mainBlue
                    )
                }

                val interactionSource = remember { MutableInteractionSource() }
                BasicTextField(

                    //value = model.enteredChat.value,
                    value = model.enteredChat.value,
                    onValueChange = { new ->
                        model.enteredChat.value = new
                    },

                    /*onValueChange = { new ->
                        model.enteredChat.value = new
                    },
                     */
                    singleLine = false,
                    maxLines = 5,
                    textStyle = TextStyle(fontSize = 23.sp, lineHeight = 30.sp, fontWeight = FontWeight(500)),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .align(Alignment.CenterStart),
                    interactionSource = interactionSource,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Default
                    ),
                ) { innerTextField ->
                    TextFieldDefaults.DecorationBox(
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            cursorColor = mainBlue,
                            unfocusedContainerColor = Color.White,
                        ),
                       // value = model.enteredChat.value,
                        value = model.enteredChat.value,
                        singleLine = true,
                        innerTextField = innerTextField,
                        enabled = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource,
                        contentPadding = PaddingValues(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp), // this is how you can remove the padding
                    )
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.align(Alignment.Bottom)) {
                if(model.enteredChat.value != ""){
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_send_24),
                            modifier = Modifier.size(22.dp),
                            contentDescription = "Icon",
                            tint = mainBlue
                        )
                    }
                }
                else{
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.camera),
                            modifier = Modifier.size(22.dp),
                            contentDescription = "Icon",
                            tint = mainBlue
                        )
                    }
                    //Spacer(modifier = Modifier.width(20.dp))

                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.record_audio),
                            modifier = Modifier.size(22.dp),
                            contentDescription = "Icon",
                            tint = mainBlue
                        )
                    }
                }
            }
            //end input part
        }
    }
    
}

