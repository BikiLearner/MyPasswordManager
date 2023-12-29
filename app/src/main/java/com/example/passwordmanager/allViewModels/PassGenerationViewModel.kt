package com.example.passwordmanager.allViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.passwordmanager.events.PassGenEvents

class PassGenerationViewModel:ViewModel() {
    private var _name by mutableStateOf("")
    var name by mutableStateOf(_name)
        private set
    private var _email by  mutableStateOf("")
    var email by mutableStateOf(_name)
        private set
    //for email
    var sliderValue by mutableFloatStateOf(0f)
    val categories = listOf("Number", "Symbol", "Lowercase", "Uppercase")
    var checkedState by mutableStateOf(List(categories.size) { false })
    val strengthOfPassword= mutableFloatStateOf(0f)
    val strengthColor= mutableStateOf(Color(0xffDADADA))
    var password by mutableStateOf("")

    fun setNameAndEmail(name:String,email:String){
        _name = name
        _email=email
    }
    fun generationEventHand(event:PassGenEvents){
        when(event){
            is PassGenEvents.EmailChange ->{}
            PassGenEvents.GenerateButtonClick -> TODO()
            is PassGenEvents.NameChange -> TODO()
            PassGenEvents.SavePassword -> TODO()
        }
    }


}