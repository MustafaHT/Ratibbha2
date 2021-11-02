package com.example.ratibbha.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ratibbha.database.model.CardModel

@Database(entities = [CardModel::class], version = 2)
abstract class taskDatabase: RoomDatabase() {
    abstract fun taskDao():TaskDao

}