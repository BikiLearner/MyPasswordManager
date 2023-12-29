package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Composable
fun PasswordInfoScreen(image: Painter,
                       passName: String,
                       email: String,link: String,
                       password: String){
    Column(modifier = Modifier) {
        FirstPart(image =image , passName = passName, email =email)
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Details & settings", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.fillMaxWidth()
            .height(2.dp)
            .border(2.dp, Color(0xff9B9B9B)))
        Spacer(modifier = Modifier.height(20.dp))
        Part2(link =link , userId = email, password = password)
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier=Modifier) {
            OutlinedButton(modifier = Modifier
                .height(50.dp)
                .width(172.dp),
                border = BorderStroke(width = 2.dp,
                    Color(0xffDADADA)),
                shape = RoundedCornerShape(5.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Copy Password")
                
            }
            OutlinedButton(modifier = Modifier
                .height(50.dp)
                .width(172.dp),
                border = BorderStroke(width = 2.dp,
                    Color(0xffDADADA)),
                shape = RoundedCornerShape(5.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Change Password")

            }
        }
    }

}
@Composable
private fun FirstPart(image:Painter,passName:String,email:String){
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Image(modifier = Modifier
            .size(96.dp)
            .clip(shape = CircleShape),
            painter = image, contentDescription = "pass logo Image")
        Column {
            Text(text = passName, fontSize = 27.sp )
            Text(text = email, fontSize = 20.sp )
        }
    }
}
@Composable
private fun Part2(link:String,userId:String,password:String){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(40.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Text(text = "Link", fontSize = 20.sp)
            Text(text = "User Id", fontSize = 20.sp)
            Text(text = "Password", fontSize = 20.sp)
            Text(text = "Autofill", fontSize = 20.sp)
        }
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Text(text = link, fontSize = 18.sp)
            Text(text = userId, fontSize = 18.sp)
            Text(text = password, fontSize = 18.sp)
            Switch(
                modifier = Modifier.scale(0.67f,0.6f),
                checked = false,
                onCheckedChange = {
                    // Your logic when the switch is checked or unchecked
                }
            )
        }
    }
}
@Preview
@Composable
fun Preview4(){
//    AnalysisListItem(
//        name = "biki",
//        password ="fafw4r54154" ,
//        strengthOfPass = 0.7.toInt(),
//        statusOfPass ="Secure" ,
//        indicatorColor = Color(0xff1ED760) ,
//        painter = painterResource(id = R.drawable.adobe)
//    )
    Surface(modifier = Modifier
        .background(Color.White)
        .padding(20.dp)
        .fillMaxSize()) {

        PasswordInfoScreen(image = painterResource(id = R.drawable.adobe),
            passName ="Adobe" , email ="bikijai2@mail" , link ="google.com"
            , password ="dsfadfdsaf" )
    }
}