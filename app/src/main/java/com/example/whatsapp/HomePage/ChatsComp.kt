package com.example.whatsapp.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R
import com.example.whatsapp.VMs.App.WhatsAppVM
import com.example.whatsapp.ui.theme.disabledText
import com.example.whatsapp.ui.theme.mainGray
import com.example.whatsapp.ui.theme.mainMessageTextColor
import com.example.whatsapp.ui.theme.messageIconColor

@Composable
fun ChatsComp(model: WhatsAppVM) {

    //test Row
    Column(modifier = Modifier.fillMaxWidth()) {


        Row(
            Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(100))
                    .background(Color.LightGray)
            )
            {
                //inja image ezafe mishe
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp), verticalArrangement = Arrangement.SpaceBetween
            ) {
                //sep
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(disabledText)
                )
                Spacer(modifier = Modifier.height(10.dp))
                //endsep

                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(75.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.9f)
                            .padding(start = 2.dp, end = 10.dp)
                        //.background(Color.Black)
                    ) {

                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Ali Farhad",
                                fontWeight = FontWeight(600),
                                fontSize = 18.sp,
                                color = Color.Black

                            )

                            Text(
                                text = "11/12/2024",
                                fontWeight = FontWeight(400),
                                fontSize = 15.sp,
                                color = mainMessageTextColor

                            )


                        }

                        Row(
                            Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                text = "hey whts up ? lemmi think about something new that can change every thing. what is your idea?",
                                fontWeight = FontWeight(600),
                                fontSize = 14.sp,
                                color = mainMessageTextColor

                            )


                        }

                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                        //  .background(Color.Yellow)
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp)
                                .align(Alignment.CenterStart),
                            painter = painterResource(id = R.drawable.shape),
                            tint = messageIconColor,
                            contentDescription = "chat Icon"
                        )
                    }
                }


                //sep
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(disabledText)
                )

                //end sep

            }

        }


    }


    //test Row

}