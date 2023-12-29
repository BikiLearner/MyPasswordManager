package com.example.passwordmanager.allScreensUi

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanager.R
import com.example.passwordmanager.dataClasses.SavedPassword

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
//    onCLickAdd: () -> Unit
    navController: NavController,
){
    val categorys= listOf(Category(
        "Work", listOf(SavedPassword("John", "john@example.com"),
            SavedPassword("Alice", "alice@example.com"),
            SavedPassword("Bob", "bob@example.com"),
            SavedPassword("Eva", "eva@example.com"),
            SavedPassword("Charlie", "charlie@example.com"))
    ), Category(
            "Entertainment", listOf(SavedPassword("John", "john@example.com"),
        SavedPassword("Alice", "alice@example.com"),
        SavedPassword("Bob", "bob@example.com"),
        SavedPassword("Eva", "eva@example.com"),
        SavedPassword("Charlie", "charlie@example.com"))
    ),
        Category(
            "Priority", listOf(SavedPassword("John", "john@example.com"),
                SavedPassword("Alice", "alice@example.com"),
                SavedPassword("Bob", "bob@example.com"),
                SavedPassword("Eva", "eva@example.com"),
                SavedPassword("Eva", "eva@example.com"),
                SavedPassword("Eva", "eva@example.com"),
                SavedPassword("Charlie", "charlie@example.com"))
        ))
        Column(modifier = Modifier.background(Color.White)
            .padding(20.dp)) {
            LazyColumn(content = {
                categorys.forEach { category ->
                  item {
                        Text(
                            text = category.name,
                            color = Color.Black,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(fonts = listOf(
                                      Font(R.font.poppins_medium)
                                )
                                ) ),
                            modifier =Modifier)
                    }
                    items(category.passwordS){password->
                        PasswordListLayout(name =password.name,
                            email =password.email, icon =painterResource(id = R.drawable.copy),
                            imageLogo =  painterResource(id = R.drawable.adobe) )
                    }
                }

            })

        }
}

data class Category(
    val name:String,
    val passwordS:List<SavedPassword>
)
@Preview
@Composable
fun Preview1(){
//    AnalysisListItem(
//        name = "biki",
//        password ="fafw4r54154" ,
//        strengthOfPass = 0.7.toInt(),
//        statusOfPass ="Secure" ,
//        indicatorColor = Color(0xff1ED760) ,
//        painter = painterResource(id = R.drawable.adobe)
//    )
    val navController= rememberNavController()
    HomeScreen(navController = navController)
}