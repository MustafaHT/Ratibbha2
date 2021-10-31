package com.example.ratibbha.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ratibbha.database.model.SigninAndRegisterModel


@Database(entities = [SigninAndRegisterModel::class],version = 1)
abstract class SigninAndRegisterDatabase: RoomDatabase() {
    abstract fun singinAndRegister():SigninAndRegisterDao
}