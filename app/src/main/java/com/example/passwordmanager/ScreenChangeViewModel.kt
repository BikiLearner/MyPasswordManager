package com.example.passwordmanager
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class ScreenChangeViewModel(
):ViewModel() {
    private val _currentScreen= mutableStateOf<Screens>(Screens.homeScreen)
    val currentScreenTitle= mutableStateOf("Password")
    val bottomNavItemSelectedIndex= mutableIntStateOf(0)
    val currentScreen:State<Screens> get()=_currentScreen
        fun navigateToGenerationScreen(){
            _currentScreen.value=Screens.passwordGenerationScreen

        }
}