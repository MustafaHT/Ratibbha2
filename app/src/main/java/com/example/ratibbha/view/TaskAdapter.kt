package com.example.ratibbha.view

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.ratibbha.R
import com.example.ratibbha.database.model.CardModel
import org.w3c.dom.Text
import java.util.*

class TaskAdapter(
    val tasks: List<CardModel>, val viewModel: TaskViewModel):
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){


    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){

        val titleEditText: TextView = view.findViewById(R.id.task_title_textview_home)
        val descreptionEditText: TextView = view.findViewById(R.id.descreption_textview_home)
        val timeFromEditText:TextView = view.findViewById(R.id.timefrom_textview_home2)
        val timeToEditText:TextView = view.findViewById(R.id.timeto_textview_home)
        val DuedateCalender:TextView = view.findViewById(R.id.dat_Calender)
        val isDone:CheckBox = view.findViewById(R.id.checkBox_home)
        val cardView: CardView = view.findViewById(R.id.card_view_home)



        //==============================================================
        val textDescreption:TextView = view.findViewById(R.id.textView3)
        val textTime:TextView = view.findViewById(R.id.textView9)
        val textdash:TextView = view.findViewById(R.id.textView7)
        val textPlace:TextView = view.findViewById(R.id.textView5)
        val textPlaceEdiTextView: TextView = view.findViewById(R.id.place_textview_home)
        val completedTextView:TextView = view.findViewById(R.id.compleated_textview)



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
        holder.DuedateCalender.setText(task.calenderDate)
        holder.isDone.isChecked = task.isDone



        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homeFragment_to_taskDetailsFragment)
            viewModel.selectedTaskMutableLiveData.postValue(task)
        }


        holder.isDone.setOnClickListener {
            task.isDone = holder.isDone.isChecked
            viewModel.updateTask(task)
//===================================When I Press Done==========================================================
            if(task.isDone){
                holder.isDone.text = "Done"
                holder.titleEditText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                holder.timeFromEditText.visibility = View.INVISIBLE
                holder.timeToEditText.visibility = View.INVISIBLE
                holder.descreptionEditText.visibility = View.INVISIBLE
                holder.DuedateCalender.visibility = View.INVISIBLE
                holder.textDescreption.visibility = View.INVISIBLE
                holder.textPlace.visibility = View.INVISIBLE
                holder.textTime.visibility = View.INVISIBLE
                holder.textdash.visibility = View.INVISIBLE
                holder.textPlaceEdiTextView.visibility = View.INVISIBLE
                holder.completedTextView.text = "Completed"

            }else{
                holder.isDone.text = "Not Done"
                holder.titleEditText.paintFlags = Paint.ANTI_ALIAS_FLAG
                holder.timeFromEditText.visibility = View.VISIBLE
                holder.timeToEditText.visibility = View.VISIBLE
                holder.descreptionEditText.visibility = View.VISIBLE
                holder.DuedateCalender.visibility = View.VISIBLE
                holder.textDescreption.visibility = View.VISIBLE
                holder.textPlace.visibility = View.VISIBLE
                holder.textTime.visibility = View.VISIBLE
                holder.textdash.visibility = View.VISIBLE
                holder.textPlaceEdiTextView.visibility = View.VISIBLE
                holder.completedTextView.text = ""
            }
        }
        //===================================================================================


        if(task.howImportant == "High" ){
            holder.cardView.setBackgroundColor(R.drawable.cardcolorhigh)
        }else if(task.howImportant  == "Normal"){
            holder.cardView.setBackgroundColor(R.drawable.cardcolornormal)
        }


    }

    override fun getItemCount(): Int {
        return tasks.size
    }
}


