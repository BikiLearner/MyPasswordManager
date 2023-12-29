package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.passwordmanager.logicalFunctions.PasswordGenerator
import com.example.passwordmanager.allViewModels.PassGenerationViewModel
import com.example.passwordmanager.logicalFunctions.evaluatePasswordStrength
import kotlin.math.roundToInt

@Preview
@Composable
fun PasswordGenerationScreen() {
    val passViewMod = viewModel<PassGenerationViewModel>()
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier
                .height(5.dp)
                .fillMaxWidth())
            CustomToolBarPassGeneration()
            Spacer(modifier = Modifier
                .height(5.dp)
                .fillMaxWidth())
            CustomTextFields(title = "Name",
                text = passViewMod.name,
                onValueChange ={passViewMod.setNameAndEmail(it,"")}  )
            Spacer(modifier = Modifier
                .height(5.dp)
                .fillMaxWidth())
            CustomTextFields(title = "Email",
                text = passViewMod.email,
                onValueChange ={passViewMod.setNameAndEmail(it,"")}  )
            //To create the line between two item
            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .blur(20.dp)
                .shadow(4.dp, ambientColor = Color.Green)
                ,
                color = Color(0xFF673AB7),
                thickness = 2.dp
            )
            Text(text = "Password", fontSize = 21.sp,
                fontFamily = FontFamily.Serif
            )
            GeneratorTextView(text = passViewMod.password,
                passViewMod.strengthOfPassword.floatValue,
                passViewMod.strengthColor)

            LengthOfPasswordUi(sliderValue=passViewMod.sliderValue,
                onValueChange = {passViewMod.sliderValue=it})


            CheckboxGrid(
                checkedState = passViewMod.checkedState,
                onCheckedChange = { index, isChecked ->
                    passViewMod.checkedState = passViewMod.checkedState.toMutableList().apply {
                        this[index] = isChecked
                    }.toList() // Convert back to an immutable list
                },
                categories = passViewMod.categories
            )



            Row {
                Button(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .weight(0.5f)
                    .padding(10.dp)
                    .height(60.dp),
                    shape = RoundedCornerShape(5.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = {
                        val pass= PasswordGenerator(
                            (passViewMod.sliderValue * 20).roundToInt(),
                            passViewMod.checkedState).giveMePassword()
                        if (pass.isNotEmpty()){
                            passViewMod.password=pass
                            val passStrength=
                                evaluatePasswordStrength(password =
                                passViewMod.password)
                            passViewMod.strengthColor.value = when {
                                passStrength < 3 -> Color.Red
                                else -> Color.Green
                            }
                            passViewMod.
                            strengthOfPassword.floatValue=passStrength*0.2f

//                            Toast.makeText(context,
//                                "Please Increase length"
//                                ,Toast.LENGTH_SHORT).show()

                        }else{
//                            Toast.makeText(context,
//                                "It is empty"
//                                ,Toast.LENGTH_SHORT).show()
                        }

                    }) {

                    Text(text = "Generate", fontSize = 17.sp,
                        color = Color.Black, fontFamily = FontFamily.Monospace)
                }
                Button(modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .weight(0.5f)
                    .padding(10.dp),
                    shape = RoundedCornerShape(5.dp),
                    border = BorderStroke(1.dp,Color.Gray),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = { /*TODO*/ }) {

                    Text(text = "Save Password", fontSize = 17.sp,
                        color = Color.Black, fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center)
                }

            }
            Text(text = "OR", modifier = Modifier
                .padding(20.dp), fontSize = 25.sp)
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp,Color.Gray),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = { /*TODO*/ }) {

                Text(text = "Add Manually", fontSize = 17.sp,
                    color = Color.Black, fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center)
            }

        }

    }
}
@Composable
fun CheckboxGrid(checkedState: List<Boolean>,
                 onCheckedChange: (Int, Boolean) -> Unit,
                 categories:List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(20.dp)
    ) {
        items(categories.size) { index ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkedState[index],
                    onCheckedChange = { isChecked ->
                        onCheckedChange(index, isChecked)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = categories[index], modifier =
                Modifier.clickable {
                   onCheckedChange(index, !checkedState[index])
                })
            }
        }
    }
}
@Composable
fun LengthOfPasswordUi(sliderValue:Float,onValueChange: (Float)->Unit) {

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "Length", fontSize = 24.sp, fontFamily = FontFamily.Serif)
        Text(text = ((sliderValue * 20).roundToInt()).toString(), fontSize = 21.sp
        ,modifier= Modifier
                .border(1.dp, Color(0xffDADADA), shape = RoundedCornerShape(4.dp))
                .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp),)
        Slider(value = sliderValue, onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(0.6f),)
    }
}

@Composable
fun GeneratorTextView(
    text: String,
    strengthOfPassword: Float,
    strengthColor: MutableState<Color>
){

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
        .height(50.dp)
    , verticalArrangement = Arrangement.SpaceBetween ) {
        Text(text = text, modifier = Modifier.fillMaxWidth(),
                fontSize = 21.sp,
                textAlign = TextAlign.Center)

        LinearProgressIndicator(modifier= Modifier
            .fillMaxWidth(0.989f)
            .align(Alignment.CenterHorizontally)
            .height(7.dp)
            .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            ,
            trackColor = Color(0xffDADADA),
            color =strengthColor.value,
            progress = strengthOfPassword,

        )
    }
}
@Composable
fun CustomTextFields(title:String,
                     text:String,
                     onValueChange:(String)->Unit){
    OutlinedTextField(value = text,
        onValueChange = onValueChange,
        label = { Text(text = title)}, modifier = Modifier
            .fillMaxWidth(0.8f))
}

// TODO = Add name function