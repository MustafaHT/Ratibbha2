package com.example.ratibbha.repositories

import android.content.Context
import androidx.room.Room
import com.example.ratibbha.database.model.CardModel
import com.example.ratibbha.database.taskDatabase
import java.lang.Exception


private const val DATABASE_NAME = "task-database"
class TaskRepository(context:Context) {

    private val database: taskDatabase =
        Room.databaseBuilder(
            context,
            taskDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration().build()



    private val taskDao = database.taskDao()

    fun getTasks() = taskDao.getTasks()

    suspend fun addTask(cardModel: CardModel) = taskDao.addTask(cardModel)
    suspend fun updateTask(cardModel: CardModel) = taskDao.updateTask(cardModel)
    suspend fun deleteTask(cardModel: CardModel) = taskDao.deleteTask(cardModel)



    companion object{
        private var instance: TaskRepository? = null

        fun init(context: Context){

            if(instance == null)
                instance = TaskRepository(context)
        }

        fun get():TaskRepository{
            return instance ?: throw Exception("Task Repository must be initialized")
        }
    }

}