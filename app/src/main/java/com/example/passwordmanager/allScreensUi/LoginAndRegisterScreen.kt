package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Preview
@Composable
fun LoginAndRegisterScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally) {
        AppDescriptor()
        Spacer(modifier = Modifier.height(40.dp))
        TextFieldSCard()
        Spacer(modifier = Modifier.height(96.dp))
        OutlinedButton(modifier = Modifier
            .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "Get verification code", fontSize = 20.sp)

        }
        OutlinedButton(modifier = Modifier
            .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "Continue Offline", fontSize = 20.sp)

        }

    }
}

@Composable
fun TextFieldSCard(){
    val listOfTextField= listOf(
        "First name","Last name","Email","Password"
    )
    Card(modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(2.dp, Color.Black),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp), horizontalAlignment =
        Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .border(
                    2.dp, Color.Black,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)) {
                Button(modifier = Modifier
                    .height(40.dp)
                    .width(164.dp),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { /*TODO*/ }) {
                    Text(modifier = Modifier
                        .fillMaxSize(),
                        textAlign = TextAlign.Center,
                        text = "Register", fontSize = 18.sp)
                }
                Button(modifier = Modifier
                    .height(40.dp)
                    .width(164.dp),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { /*TODO*/ }) {
                    Text(modifier = Modifier
                        .fillMaxSize(),
                        textAlign = TextAlign.Center,
                        text = "Login", fontSize = 18.sp)
                }

            }
            Text(modifier = Modifier
                .fillMaxWidth(),
                text = "Personal details", fontSize = 20.sp)
            Column(verticalArrangement = Arrangement.
            spacedBy(10.dp)) {
               listOfTextField.forEach {label->
                   OutlinedTextField(modifier = Modifier
                       .fillMaxWidth(),
                       value = "", onValueChange = {
                           "hello"
                       },
                       label={
                            Text(text = label)
                       })

               }
            }
        }

    }
}
@Composable
fun AppDescriptor(){
    Column(horizontalAlignment =
    Alignment.CenterHorizontally) {
        Image( modifier= Modifier.size(83.dp),
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription ="App logo" )
        Text(text = "LockUp", fontSize = 34.sp)
        Text(text = "Ultimate Security", fontSize = 18.sp)
    }
}