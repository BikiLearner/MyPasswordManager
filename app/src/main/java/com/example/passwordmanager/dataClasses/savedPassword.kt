package com.example.passwordmanager.dataClasses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PassTable")
data class SavedPassword(
    @PrimaryKey(autoGenerate = true)
    val passwordId: Int = 0,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Email") val email: String,
    @ColumnInfo(name = "Password") val password: String,
    val passwordCategory: String
) {
    // Secondary constructor with default values
    constructor(name: String, email: String) : this(0, name, email, "", "")
}
