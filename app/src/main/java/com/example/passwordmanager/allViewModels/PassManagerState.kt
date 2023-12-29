package com.example.passwordmanager.allViewModels

import com.example.passwordmanager.dataClasses.PassDetailsData

data class PassManagerState(
    val passList: List<PassDetailsData> = emptyList(),
)
