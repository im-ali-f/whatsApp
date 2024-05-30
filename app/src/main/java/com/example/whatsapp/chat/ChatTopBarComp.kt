package com.example.whatsapp.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whatsapp.R
import com.example.whatsapp.ui.theme.enabledText
import com.example.whatsapp.ui.theme.mainBlue
import com.example.whatsapp.ui.theme.mainGray
import com.example.whatsapp.ui.theme.mainMessageTextColor

@Composable
fun TopChatBarComp(navControllerBig: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(mainGray)
            .padding(end = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { navControllerBig.navigate("homePage") }) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                modifier = Modifier.size(23.dp),
                contentDescription = "Icon",
                tint = mainBlue
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { }
            .padding(start = 5.dp, end = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(100))
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Ali Farhad",
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "tap here for contact info",
                    fontWeight = FontWeight(400),
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = mainMessageTextColor
                )

            }
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.videocall),
                    modifier = Modifier.size(25.dp),
                    contentDescription = "Icon",
                    tint = mainBlue
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.call),
                    modifier = Modifier.size(25.dp),
                    contentDescription = "Icon",
                    tint = mainBlue
                )
            }

        }


    }
}