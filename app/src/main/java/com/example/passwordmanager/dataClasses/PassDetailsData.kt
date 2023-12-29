package com.example.passwordmanager.dataClasses

import androidx.compose.ui.graphics.ImageBitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passwordTable")
data class PassDetailsData(
    @PrimaryKey(autoGenerate = true)
    val passId:Int,
    val passName:String,
    val passEmail:String,
    val passPlatformLink:String,
    val passWord:String,
    val passIcon:ImageBitmap,
    val passCategory:String
)
