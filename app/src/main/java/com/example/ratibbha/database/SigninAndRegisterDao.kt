package com.example.ratibbha.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ratibbha.database.model.SigninAndRegisterModel


@Dao
interface SigninAndRegisterDao {

    @Insert
    suspend fun registerUser(signinAndRegisterModel: SigninAndRegisterModel)

    @Query("SELECT * FROM signinAndRegisterModel")
    fun getUsers():LiveData<List<SigninAndRegisterModel>>

}