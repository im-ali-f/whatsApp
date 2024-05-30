package com.example.whatsapp.chat

import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.ui.theme.mainBlue

@Composable
fun ChatComp() {
    val chatList = mutableListOf(
        mapOf(
            "sender" to "Ali farhad",
            "sendDate" to "11/11/2011",
            "sendTime" to "11:11",
            "editDate" to "12/11/2011",
            "editTime" to "12:12",
            "text" to "Now ; your turn to chat with us !",
            "type" to "send",
        ),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray), verticalArrangement = Arrangement.Bottom
    ) {
        LazyColumn {
            items(chatList) { chatMap ->

                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Blue)
                ) {
                    Row(Modifier.padding(start = 7.dp)) {
                        Canvas(modifier = Modifier
                            .size(25.dp)
                            .align(Alignment.Bottom)
                            .offset(y = -10.dp, x = 2.dp)) {
                            val path = Path().apply {
                                moveTo(0f, size.height-30f)
                                //lineTo(size.width , size.height)
                                cubicTo(x1 = 0f,y1=size.height-30f , x2 = size.width/2, y2 = size.height, x3= size.width, y3 =size.height )
                                lineTo(size.width , 0f)
                                cubicTo(x1 = size.width,y1=0f , x2 = size.width/2, y2 = size.height/2+20f, x3= 0f, y3 =size.height-30f )
                                close()
                            }
                            drawPath(path = path, color = Color.Red)
                        }

                        Box(
                            modifier = Modifier
                                .padding(end = 5.dp, bottom = 5.dp)
                                .widthIn(min = 100.dp, max = 270.dp)
                                .heightIn(min = 40.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.Yellow)
                                .padding(5.dp)
                        ) {

                            Text(
                                text = "StatusStatusStatusStatusStatusS ugdkjwg jwdjh   jhd whklhdwkhkdw    dwkhktatusStatus Status Status Status Status",
                                fontWeight = FontWeight(400),
                                fontSize = 16.sp,
                                color = Color.Black,
                            )
                            Box(modifier = Modifier.align(Alignment.BottomEnd) ){
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


@Preview
@Composable
fun prev() {
    ChatComp()
}