package com.example.ratibbha.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import com.example.ratibbha.R
import com.example.ratibbha.database.model.CardModel

class TaskAdapter(
    val tasks: List<CardModel>, val viewModel: TaskViewModel):
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){



    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){

        val titleEditText: EditText = view.findViewById(R.id.task_title_textview_home)
        val descreptionEditText: EditText = view.findViewById(R.id.descreption_textview_home)
        val timeFromEditText:EditText = view.findViewById(R.id.timefrom_textview_home2)
        val timeToEditText:EditText = view.findViewById(R.id.timeto_textview_home)
        val checkBox:CheckBox = view.findViewById(R.id.checkBox_home)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

        val task = tasks[position]

        holder.titleEditText.setText(task.title)
        holder.descreptionEditText.setText(task.descreption)
        holder.timeFromEditText.setText(task.timeFrom)
        holder.timeToEditText.setText(task.timeTo)
        holder.checkBox.isChecked = task.isDone

    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}

