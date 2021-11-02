package com.example.ratibbha.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CardModel(
    var title:String,
    var descreption:String,
    var calenderDate: String,
    var timeFrom: String,
    var timeTo: String,
    var taskFor: String,
    var typeofTask:String,
    var howImportant:String,
    var place: String,
    var isDone:Boolean,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
)
