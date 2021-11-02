package com.example.ratibbha.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ratibbha.database.model.CardModel
import com.example.ratibbha.repositories.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {


    private val taskRepository = TaskRepository.get()

    var taskElements = taskRepository.getTasks()

    var selectedTaskMutableLiveData = MutableLiveData<CardModel>()

    fun addTask(
        title: String,
        descreption: String,
        calenderDate: Int,
        timeFrom: Int,
        timeTo: Int,
        place: String,
        isDone: Boolean,
        howImportant:String,
        taskFor:String,
        typeofTask:String
    ) {
        viewModelScope.launch {
            taskRepository.addTask(
                CardModel(
                    title, descreption, calenderDate, timeFrom, timeTo,
                    taskFor, typeofTask, howImportant, place, isDone
                )
            )
//
//            val title:String,
//            val descreption:String,
//            val calenderDate:Int,
//            val timeFrom:Int,
//            val timeTo:Int,
//            val taskFor: List<String>,
//            val typeOfTask:String,
//            val howImportant:String,
//            val place:String,
//            var isDone:Boolean,
        }
    }

        fun updateTask(cardModel: CardModel) {
            viewModelScope.launch {
                taskRepository.updateTask(cardModel)
            }
        }

            fun deleteTask(cardModel: CardModel){
                viewModelScope.launch {
                    taskRepository.deleteTask(cardModel)
                }
            }
    }