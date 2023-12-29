package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R


@Composable
fun TopAppBar(onCLickAdd:()->Unit,title:String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)
        .height(70.dp)
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Icon(modifier = Modifier.size(34.dp),
            imageVector = Icons.Default.Person, contentDescription ="Profile")
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Icon(modifier = Modifier
            .size(34.dp)
            .clickable {
                onCLickAdd()
            },
            imageVector = Icons.Default.Add, contentDescription ="Profile")
    }
}

@Composable
fun PasswordListLayout(name:String,email:String,icon:Painter,imageLogo:Painter){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent)
        .height(70.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,) {
            Row {
                    Image(
                        painter =imageLogo,
                        contentDescription = "behance",
                        modifier = Modifier
                            .requiredSize(size = 62.dp)
                            .fillMaxSize()
                            .clip(shape = CircleShape)
                            .background(color = Color.Transparent)
                    )
                Spacer(modifier = Modifier.width(20.dp))
                Column(verticalArrangement = Arrangement.SpaceBetween) {
                    Text(
                        text = name,
                        color = Color(0xff292d32),
                        style = TextStyle(
                            fontSize = 20.sp),
                        modifier = Modifier)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = email,
                        color = Color(0xff808080),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Light),
                        modifier = Modifier)

                }

            }
            Icon(painter =icon,
                contentDescription = "Copy" )
        }
    }

@Composable
fun CustomToolBarPassGeneration(){
    Row(horizontalArrangement = Arrangement.SpaceBetween
        ,modifier= Modifier
            .fillMaxWidth()
            .padding(15.dp)) {

        Icon(painter = painterResource(id = R.drawable.baseline_keyboard_backspace_24),
            contentDescription ="Back Button",
            modifier = Modifier
                .size(36.dp)
                .align(Alignment.CenterVertically)
            ,

            )
        Text(text = "New Password",
            style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.size(36.dp))
    }
}

@Composable
fun SearchToolBar(){
   //TODO Latter
}

@Preview
@Composable
fun Priview3(){
    PasswordListLayout(name = "hi", email ="dfsaf56ds56f4" , 
        icon = painterResource(id = R.drawable.arrow_forward_ios_24px),
        imageLogo = painterResource(id = R.drawable.adobe))
}