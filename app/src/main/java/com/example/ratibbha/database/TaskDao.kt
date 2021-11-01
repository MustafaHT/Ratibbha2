package com.example.ratibbha.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ratibbha.database.model.CardModel


@Dao
interface TaskDao {
    @Insert
    suspend fun addTask(cardModel: CardModel)

    @Query("SELECT * From cardmodel")
    fun getTasks():LiveData<List<CardModel>>

    @Update
    suspend fun updateTask(cardModel: CardModel)

    @Delete
    suspend fun deleteTask(cardModel: CardModel)

}