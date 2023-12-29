package com.example.passwordmanager.database.Room
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.passwordmanager.dataClasses.PassDetailsData
import kotlinx.coroutines.flow.Flow

@Dao
interface PassDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPass(item:PassDetailsData)

    @Update
    suspend fun updatePass(item:PassDetailsData)


    @Delete
    suspend fun delete(item: PassDetailsData)

    @Query("SELECT * FROM PASSWORDTABLE where passCategory=:category")
    fun getItemByCategory(category:String):Flow<List<PassDetailsData>>

    @Query("select * from passwordTable ORDER BY passName ASC")
    fun getAllItems():Flow<List<PassDetailsData>>

}