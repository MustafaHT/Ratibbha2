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
        val typeOfTaskTextView: Spinner = view.findViewById(R.id.typeoftask_spinner_edit)
        val taskForTextView: Spinner = view.findViewById(R.id.taskfor_spinner_edit)
        val placeTextView: Spinner = view.findViewById(R.id.place_spinner_edit)
        val howImportantTextView: Spinner = view.findViewById(R.id.howimportant_spinner_edit)
        val editButton: Button = view.findViewById(R.id.add_button_edit)




        taskViewModel.selectedTaskMutableLiveData.observe(viewLifecycleOwner, Observer {
            it?.let { task ->

                titleTextView.setText(task.title)
                descreptionTextView.setText(task.descreption)
                val res = resources.getStringArray(R.array.taskType).toList()
                val res2 = resources.getStringArray(R.array.TaskPlace).toList()
                val res3= resources.getStringArray(R.array.howImportance).toList()
                val res4 = resources.getStringArray(R.array.TaskFor).toList()


                typeOfTaskTextView.setSelection(res.indexOf(it.typeofTask))
                taskForTextView.setSelection(res2.indexOf(it.taskFor))
                placeTextView.setSelection(res3.indexOf(it.place))
                howImportantTextView.setSelection(res4.indexOf(it.howImportant))
                selectedTask = task
            }
        })


        editButton.setOnClickListener {
            selectedTask.title = titleTextView.text.toString()
            selectedTask.descreption = descreptionTextView.text.toString()
            selectedTask.typeofTask = typeOfTaskTextView.selectedItem.toString()
            selectedTask.taskFor = taskForTextView.selectedItem.toString()
            selectedTask.place = placeTextView.selectedItem.toString()
            selectedTask.howImportant = howImportantTextView.selectedItem.toString()
            taskViewModel.updateTask(selectedTask)
            findNavController().navigate(R.id.action_editFragment_to_homeFragment)
        }





    }




}