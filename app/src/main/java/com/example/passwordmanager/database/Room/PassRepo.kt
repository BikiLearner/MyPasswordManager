package com.example.passwordmanager.database.Room

import com.example.passwordmanager.dataClasses.PassDetailsData
import kotlinx.coroutines.flow.Flow

interface PassRepo {
    //Retrieve  all the item from the database
    fun getAllItemStream():Flow<List<PassDetailsData>>

    //Retrieve passwords by Category(Priority,work,entertainment)
    fun getAllPassByCategory(category:String):Flow<List<PassDetailsData>>

    /**
     * Insert item in the data source
     */
    suspend fun insertPassword(passDetailsData: PassDetailsData)

    /**
     * Delete item from the data source
     */
    suspend fun deletePassword(passDetailsData: PassDetailsData)

    /**
     * Update item in the data source
     */
    suspend fun updatePassword(passDetailsData: PassDetailsData)
}