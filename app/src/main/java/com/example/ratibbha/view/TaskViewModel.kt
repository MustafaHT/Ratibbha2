package com.example.ratibbha.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ratibbha.database.model.CardModel
import com.example.ratibbha.repositories.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel: ViewModel() {


    private val taskRepository = TaskRepository.get()

    var taskElements = taskRepository.getTasks()

    fun addTask(title:String,descreption:String,pickUpDay:Int,timeFrom:Int,timeTo:Int,place:String,isDone:Boolean){
        viewModelScope.launch {
            taskRepository.addTask(CardModel(title,descreption,pickUpDay,timeFrom,timeTo,place,isDone))
        }

        fun updateTask(cardModel: CardModel){
            viewModelScope.launch {
                taskRepository.updateTask(cardModel)
            }

            fun deleteTask(cardModel: CardModel){
                viewModelScope.launch {
                    taskRepository.deleteTask(cardModel)
                }
            }
        }

    }
}