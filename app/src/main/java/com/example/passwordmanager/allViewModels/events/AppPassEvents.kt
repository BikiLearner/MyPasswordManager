package com.example.passwordmanager.allViewModels.events

import androidx.compose.ui.graphics.ImageBitmap
import com.example.passwordmanager.dataClasses.PassDetailsData

sealed interface AppPassEvents {
    data class DeletePass(val passDetailsData: PassDetailsData):AppPassEvents
    data class SavePass(
        val passId:Int,
        val passName:String,
        val passEmail:String,
        val passPlatformLink:String,
        val passWord:String,
        val passIcon: ImageBitmap,
        val passCategory:String
    ):AppPassEvents
}