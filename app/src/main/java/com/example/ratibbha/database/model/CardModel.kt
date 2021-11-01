package com.example.ratibbha.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CardModel(
    val title:String,
    val descreption:String,
    val timeFrom:Int,
    val timeTo:Int,
    val place:String,
    var isDone:Boolean,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
)
