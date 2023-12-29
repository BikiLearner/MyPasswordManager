package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Composable
fun ProfileScreen(
    accountName:String,
    image:Painter,
    name:String,
    email:String,
    ){
    val options= listOf("Security","Trusted devices","Backup")
   Column(modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.SpaceEvenly) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Image(modifier = Modifier
                .size(96.dp)
                .clip(shape = CircleShape),
                painter = image, contentDescription = "Profile Image")
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = name, fontSize = 20.sp)
            Text(text = email, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Edit profile", fontSize = 16.sp)
            }
        }
       Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
           Row(modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween) {
               Text(text = "Switch Account", fontSize = 20.sp)
               Row(modifier = Modifier
                   .height(30.dp)
                   .clip(shape = RoundedCornerShape(5.dp))
                   .background(Color(0xffF2F2F2))
                   .width(149.dp)
                   .padding(start = 10.dp)
                   ,
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.spacedBy(10.dp)
               ) {
                   Text(text =accountName, fontSize = 16.sp)
                   Icon(modifier = Modifier.fillMaxSize(),
                       imageVector = Icons.Default.KeyboardArrowDown,
                       contentDescription ="Drop down" )
               }
           }
           options.forEach {option->
               Row(modifier = Modifier.fillMaxWidth()
                   ,verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.SpaceBetween) {
                   Text(text = option, fontSize = 20.sp)
                   Icon(painter = painterResource(id = R.drawable.arrow_forward_ios_24px),
                       contentDescription ="Nothing" )
               }
           }
       }
       OutlinedButton(onClick = { /*TODO*/ }) {
           Text(text = "Logout", fontSize = 16.sp)
           
       }
   }
}

