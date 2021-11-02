package com.example.ratibbha.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ratibbha.R
import com.example.ratibbha.database.model.CardModel
import org.w3c.dom.Text


class TaskDetailsFragment : Fragment() {

    private  val taskViewModel:TaskViewModel by activityViewModels()
    private lateinit var  selectedTask:CardModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titelTextView:TextView = view.findViewById(R.id.title_textView_Details)
        val descreptionTextView:TextView = view.findViewById(R.id.descreption_TextView_Details)
        val timeFromTextView:TextView = view.findViewById(R.id.timeFrom_textView_Details)
        val timeToTextView:TextView = view.findViewById(R.id.timeTo_TextView_Details)
        val dueDateTextView:TextView = view.findViewById(R.id.day_textView_Details)
        val typeOfTaskTextView:TextView = view.findViewById(R.id.typeOfTask_TextView_Details)
        val taskForTextView:TextView = view.findViewById(R.id.taskFor_TextView_Details)
        val placeTextView: TextView = view.findViewById(R.id.place_TextView_Details)
        val howImportantTextView:TextView = view.findViewById(R.id.howImportant_TextView_Details)
        val isDoneTextView:TextView = view.findViewById(R.id.isDone_TextView_Details)
        val deleteButton:ImageButton = view.findViewById(R.id.deleteButton_ImageButton_Details)
        val editButton:ImageButton = view.findViewById(R.id.editButton_ImageButton_Details)

        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { task ->
                selectedTask = task
                titelTextView.text = task.title
                descreptionTextView.text = task.descreption
                timeFromTextView.text = task.timeFrom.toString()
                timeToTextView.text = task.timeTo.toString()
                dueDateTextView.text = task.calenderDate.toString()
                typeOfTaskTextView.text = task.typeofTask
                taskForTextView.text = task.place.toString()
                placeTextView.text = task.place.toString()
                howImportantTextView.text = task.howImportant
                isDoneTextView.text = task.isDone.toString()

            }
        })

        deleteButton.setOnClickListener {
            taskViewModel.deleteTask(selectedTask)
            findNavController().popBackStack()
        }

    }
}