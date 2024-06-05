package com.example.whatsapp.chat

import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.ui.theme.mainBlue
import com.example.whatsapp.ui.theme.sendBGCColor

@Composable
fun ChatComp(model:WhatsAppVM) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
        , verticalArrangement = Arrangement.Bottom
    ) {
        val scrollState = rememberLazyListState()
        LaunchedEffect(model.chatList.value) {
            scrollState.animateScrollToItem(index = model.chatList.value.size)
        }
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(start = 7.dp, end = 7.dp),
            state = scrollState,
        ) {
            item { 
                Spacer(modifier = Modifier.heightIn(10.dp))
            }
            items(model.chatList.value) { chatMap ->
                CompositionLocalProvider(LocalLayoutDirection provides if(chatMap["type"] == "send")LayoutDirection.Rtl else LayoutDirection.Ltr ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            //.background(Color.Blue)
                    ) {
                        Row(Modifier.padding()) {

                                if(chatMap["type"] == "send"){
                                    Canvas(modifier = Modifier
                                        .size(25.dp)
                                        .align(Alignment.Bottom)
                                        .offset(y = -10.dp, x = 8.dp)
                                    )
                                    {
                                        if(chatMap["haveTail"] =="true") {
                                            val path = Path().apply {
                                                moveTo(size.width, size.height - 30f)
                                                //lineTo(size.width , size.height)
                                                cubicTo(
                                                    x1 = size.width,
                                                    y1 = size.height - 30f,
                                                    x2 = size.width / 2,
                                                    y2 = size.height,
                                                    x3 = 0f,
                                                    y3 = size.height
                                                )
                                                lineTo(0f, 0f)
                                                cubicTo(
                                                    x1 = 0f,
                                                    y1 = 0f,
                                                    x2 = size.width / 2,
                                                    y2 = size.height / 2 + 20f,
                                                    x3 = size.width,
                                                    y3 = size.height - 30f
                                                )
                                                close()
                                            }
                                            drawPath(path = path, color = sendBGCColor)
                                        }
                                    }

                                }
                                else{
                                    Canvas(modifier = Modifier
                                        .size(25.dp)
                                        .align(Alignment.Bottom)
                                        .offset(y = -10.dp, x = 8.dp))
                                    {
                                        if(chatMap["haveTail"] =="true") {
                                            val path = Path().apply {
                                                moveTo(0f, size.height - 30f)
                                                //lineTo(size.width , size.height)
                                                cubicTo(
                                                    x1 = 0f,
                                                    y1 = size.height - 30f,
                                                    x2 = size.width / 2,
                                                    y2 = size.height,
                                                    x3 = size.width,
                                                    y3 = size.height
                                                )
                                                lineTo(size.width, 0f)
                                                cubicTo(
                                                    x1 = size.width,
                                                    y1 = 0f,
                                                    x2 = size.width / 2,
                                                    y2 = size.height / 2 + 20f,
                                                    x3 = 0f,
                                                    y3 = size.height - 30f
                                                )
                                                close()
                                            }
                                            drawPath(path = path, color = Color.White)
                                        }
                                    }
                                }



                            Box(
                                modifier = Modifier
                                    .padding(end = 5.dp, bottom = 5.dp)
                                    .widthIn(min = 100.dp, max = 270.dp)
                                    .heightIn(min = 40.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (chatMap["type"] == "send") sendBGCColor else Color.White)
                                    .padding(5.dp)
                            ) {

                                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ) {
                                    chatMap["text"]?.let {
                                        Text(
                                            text = it + "\n",
                                            fontWeight = FontWeight(400),
                                            fontSize = 16.sp,
                                            color = Color.Black,
                                            //textAlign = if(chatMap["type"] == "send")TextAlign.End else TextAlign.Start
                                        )
                                    }
                                }
                                Box(modifier = Modifier.align(if(chatMap["type"] == "send") Alignment.BottomStart else Alignment.BottomEnd) ){
                                    Text(
                                        modifier = Modifier.alpha(0.5f),
                                        text = "11:45",
                                        fontWeight = FontWeight(400),
                                        fontSize = 11.sp,
                                        color = Color.Black,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            }
                        }
                    }
                }


            }


        }
    }
}

