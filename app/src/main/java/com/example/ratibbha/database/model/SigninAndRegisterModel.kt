package com.example.ratibbha.database.model

import androidx.room.PrimaryKey

data class SigninAndRegisterModel(
    val userName: String,
    val password: String,
    val email: String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)
