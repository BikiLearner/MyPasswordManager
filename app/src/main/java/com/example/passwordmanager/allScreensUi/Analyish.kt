package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Composable
fun AnalysisScreen(){
  Column(modifier = Modifier,
      horizontalAlignment = Alignment.CenterHorizontally,
      ) {
      Box(contentAlignment = Alignment.Center) {
          CircularProgressIndicator(
              modifier = Modifier
                  .size(128.dp)
                  .border(width = 2.dp, Color.Black, shape = CircleShape)
                  ,
              strokeCap = StrokeCap.Round,
              strokeWidth = 10.dp,
              color =Color.White ,
              trackColor = Color.Black,
              progress = 0.4f
          )
          Spacer(modifier = Modifier
              .size((110).dp)
              .border(width = 2.dp, Color.Black, shape = CircleShape)
          )

          Text(text = "84%", fontSize = 24.sp)
      }
      Spacer(modifier = Modifier.height(10.dp))
      Text(text = "82% secure", fontSize = 20.sp)
      Spacer(modifier = Modifier.height(30.dp))
      Row(modifier=Modifier
          .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        CardToTellWeakStrongSecure(noOfPass ="82", passStatus ="Strong" )
        CardToTellWeakStrongSecure(noOfPass ="43" , passStatus ="Weak" )
        CardToTellWeakStrongSecure(noOfPass ="10" , passStatus ="Risk" )
      }
      Spacer(modifier = Modifier.height(30.dp))
      Row(modifier=Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween) {
          Text(text = "Analysis", fontSize = 30.sp)
          Icon(painter = painterResource(id = R.drawable.filter_list_24px),
              contentDescription ="Filter list Icon" )
      }
        LazyColumn(modifier = Modifier,content = {
            items(5){
                AnalysisListItem(
                    name = "biki",
                    password ="fafw4r54154" ,
                    strengthOfPass = 70,
                    statusOfPass ="Secure" ,
                    indicatorColor = Color.Green ,
                    painter = painterResource(id = R.drawable.adobe)
                )
            }
        })
  }
}
@Composable
private fun CardToTellWeakStrongSecure(noOfPass:String,passStatus:String){
    Box(modifier = Modifier
        .size(90.dp)
        .border(2.dp,
            color = Color(0xffB4B4B4),
            shape =RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center) {
        Column(modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)) {
            //It tell no of password which is secured or not
            Text(text = noOfPass,
                fontSize = 24.sp)
            //it tells password is safe secure or not safe
            Text(text = passStatus, fontSize = 20.sp)

        }

    }
}
@Composable
fun AnalysisListItem(
    name:String,
    password:String,
    strengthOfPass:Int,
    statusOfPass:String,
    indicatorColor:Color,
    painter: Painter
){
    Column {
        PasswordListLayout(name = name,
            email =password ,
            icon = painterResource(id = R.drawable.arrow_forward_ios_24px),
            imageLogo = painter)
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(
                start = 10.dp,
                end = 10.dp, top = 5.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            Text(text = statusOfPass, fontSize = 21.sp)
            LinearProgressIndicator(modifier = Modifier
                .height(5.dp),
                color = indicatorColor,
                trackColor = Color(0xffD9D9D9),
                progress = 0.5f,
                strokeCap = StrokeCap.Round,

            )
        }
    }
}
