package com.example.passwordmanager.database.Room

import com.example.passwordmanager.dataClasses.PassDetailsData
import com.example.passwordmanager.database.Room.PassDao
import com.example.passwordmanager.database.Room.PassRepo
import kotlinx.coroutines.flow.Flow

class OfflinePasswordRepo(private val passDao: PassDao): PassRepo {
    override fun getAllItemStream(): Flow<List<PassDetailsData>> {
        return passDao.getAllItems()
    }

    override fun getAllPassByCategory(category: String): Flow<List<PassDetailsData>> {
        return passDao.getItemByCategory(category)
    }

    override suspend fun insertPassword(passDetailsData: PassDetailsData) {
        return passDao.insertPass(passDetailsData)
    }

    override suspend fun deletePassword(passDetailsData: PassDetailsData) {
        return passDao.delete(passDetailsData)
    }

    override suspend fun updatePassword(passDetailsData: PassDetailsData) {
        return passDao.updatePass(passDetailsData)
    }
}