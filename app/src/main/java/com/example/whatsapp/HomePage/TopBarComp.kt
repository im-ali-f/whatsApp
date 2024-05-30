package com.example.whatsapp.HomePage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.whatsapp.R
import com.example.whatsapp.ui.theme.disabledText
import com.example.whatsapp.ui.theme.enabledText
import com.example.whatsapp.ui.theme.mainBlue
import com.example.whatsapp.ui.theme.mainGray

@Composable
fun TopBarComp() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(mainGray)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Chats",
            fontWeight = FontWeight(600),
            fontSize = 17.sp,
            textAlign = TextAlign.Center,

            )

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 12.5.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.edit_icon),
                    modifier = Modifier.size(23.dp),
                    contentDescription = " toggle pass word Icon",
                    tint = mainBlue
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 12.5.dp)
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {  }
                    .padding(5.dp),
                text = "Edit",
                fontWeight = FontWeight(400),
                fontSize = 17.sp,
                textAlign = TextAlign.Center,
                color = enabledText
            )
        }



    }
}