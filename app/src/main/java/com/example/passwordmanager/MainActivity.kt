package com.example.passwordmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passwordmanager.allScreensUi.HomeScreen
import com.example.passwordmanager.allScreensUi.PasswordGenerationScreen
import com.example.passwordmanager.ui.theme.PasswordManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordManagerTheme {
                val navController= rememberNavController()
                NavHost(navController = navController,
                    startDestination ="homescreen"){
                    composable("homescreen"){ HomeScreen(navController = navController) }
                    composable("passwordgeneration"){
                        PasswordGenerationScreen()
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PasswordManagerTheme {
        Greeting("Android")
    }
}