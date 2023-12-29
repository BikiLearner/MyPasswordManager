package com.example.passwordmanager.events

sealed class PassGenEvents {
    data class NameChange(val newName:String):PassGenEvents()
    data class EmailChange(val newName:String):PassGenEvents()

    object GenerateButtonClick:PassGenEvents()
    object SavePassword:PassGenEvents()


}