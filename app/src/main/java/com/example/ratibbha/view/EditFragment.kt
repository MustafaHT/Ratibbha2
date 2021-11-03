package com.example.ratibbha.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.ratibbha.R
import com.example.ratibbha.database.model.CardModel


class EditFragment : Fragment() {

    private  val taskViewModel:TaskViewModel by activityViewModels()
    private lateinit var  selectedTask: CardModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView: EditText = view.findViewById(R.id.title_edit_textview_edit)
        val descreptionTextView: EditText = view.findViewById(R.id.descreption_edit_textview_edit)
//        var timeFromTextView: TextView = view.findViewById(R.id.timeFrom_textView_Details)
//        var timeToTextView: TextView = view.findViewById(R.id.timeTo_TextView_Details)
//        var dueDateTextView: TextView = view.findViewById(R.id.day_textView_Details)
        val typeOfTaskTextView: Spinner = view.findViewById(R.id.typeoftask_spinner_edit)
        val taskForTextView: Spinner = view.findViewById(R.id.taskfor_spinner_edit)
        val placeTextView: Spinner = view.findViewById(R.id.place_spinner_edit)
        val howImportantTextView: Spinner = view.findViewById(R.id.howimportant_spinner_edit)
//        val isDoneTextView: CheckBox = view.findViewById(R.id.isDone_TextView_Details)
//        val deleteButton: ImageButton = view.findViewById(R.id.deleteButton_ImageButton_Details)
        val editButton: Button = view.findViewById(R.id.add_button_edit)
        val addButton:Button = view.findViewById(R.id.add_button_edit)




        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { task ->

                titleTextView.setText(task.title)
                descreptionTextView.setText(task.descreption)
                val res = resources.getStringArray(R.array.taskType).toList()

                typeOfTaskTextView.setSelection(res.indexOf(it.typeofTask))
//                typeOfTaskTextView.text = task.typeofTask
//                taskForTextView.text = task.taskFor
//                placeTextView.text = task.place
//                howImportantTextView.text = task.howImportant
                selectedTask = task
            }
        })

//        deleteButton.setOnClickListener {
//            taskViewModel.deleteTask(selectedTask)
//            findNavController().navigate(R.id.action_taskDetailsFragment_to_homeFragment2)
//        }

        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { task ->

                titleTextView.setText(task.title)
                descreptionTextView.setText(task.descreption)
//                timeFromTextView.
//                timeToTextView.
//                dueDateTextView.
                typeOfTaskTextView.selectedItem
                taskForTextView.selectedItem
                placeTextView.selectedItem
                howImportantTextView.selectedItem
//                isDoneTextView.setText(task.isDone.toString())
                selectedTask = task

            }
        })

        editButton.setOnClickListener {
            selectedTask.title = titleTextView.text.toString()
            selectedTask.descreption = descreptionTextView.text.toString()
//            selectedTask.timeFrom = timeFromTextView.text.toString()
//            selectedTask.timeTo = timeToTextView.text.toString()
//            selectedTask.calenderDate = dueDateTextView.text.toString()
            selectedTask.typeofTask = typeOfTaskTextView.toString()
            selectedTask.taskFor = taskForTextView.toString()
            selectedTask.place = placeTextView.toString()
            selectedTask.howImportant = howImportantTextView.toString()
//            selectedTask.isDone = isDoneTextView.isChecked

            taskViewModel.updateTask(selectedTask)
            findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }





    }




}