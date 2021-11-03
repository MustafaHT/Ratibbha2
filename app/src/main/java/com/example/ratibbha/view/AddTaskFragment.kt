package com.example.ratibbha.view

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.text.SimpleDateFormat
import android.icu.util.ULocale
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ratibbha.R
import java.util.*


// DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener =======>>> used to implement time ((onDateSet & onTimeSet))
class AddTaskFragment : Fragment(), DatePickerDialog.OnDateSetListener {



    //==================================== variables used for the Calender =============================================
    lateinit var addDateAndTime:ImageButton
    lateinit var CalendarDate: TextView
    lateinit var timeFromText:TextView
    lateinit var timeToText:TextView

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    val cal: Calendar = Calendar.getInstance()

    var day = cal.get(Calendar.DAY_OF_MONTH)
    var month = cal.get(Calendar.MONTH)
    var year = cal.get(Calendar.YEAR)

    var hour = cal.get(Calendar.HOUR)
    var minute = cal.get(Calendar.MINUTE)


    //====================================
    var timeTo = ""
    var timeFrom = ""
    //====================================
    var currentDay = "$day/$month/$year"


//    var CurrentTime = "$hour:$minute"
//==================================== variables used for the Calender =============================================



    private val taskViewModel:TaskViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //=====================================================***************==============================
                            // these elements declared for ''Calender'' -->> Inside addTaskFragment
        addDateAndTime= view.findViewById(R.id.pickupaday_edit_imagebutton_textview_add)
        CalendarDate = view.findViewById(R.id.calenderDate_TextView_add)
        timeToText = view.findViewById(R.id.timeTo_Text_add)
        timeFromText = view.findViewById(R.id.timeFrom_Text_add)
        //=====================================================***************=================================
                            // here other elements that we are gonna use for Task Details

        val titleEditText: EditText = view.findViewById(R.id.title_edit_textview_add)
        val descreptionEditText: EditText = view.findViewById(R.id.descreption_edit_textview_add)
        val typeOfTaskSpinner: Spinner = view.findViewById(R.id.typeoftask_spinner_add)
        val taskForSpinner: Spinner = view.findViewById(R.id.taskfor_spinner_add)
        val placeSpinner:Spinner = view.findViewById(R.id.place_spinner_add)
        val howImportantSpinner:Spinner = view.findViewById(R.id.howimportant_spinner_add)
        val addButton:Button = view.findViewById(R.id.add_button_add)



        typeOfTaskSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        taskForSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

//==========================================(Add Button Part)============================================================


        addButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val descreption = descreptionEditText.text.toString()
            val calendarDate = CalendarDate.text.toString()
            val timeFrom = timeFromText.text.toString()
            val timeTo = timeToText.text.toString()



            taskViewModel.addTask(
                title,
                descreption,
                calendarDate,
                timeFrom,
                timeTo,
                placeSpinner.selectedItem.toString(),
                false,
                howImportantSpinner.selectedItem.toString(),
                taskForSpinner.selectedItem.toString(),
                typeOfTaskSpinner.selectedItem.toString()
            )


            findNavController().popBackStack()
        }

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^(Add Button Part)^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


        // ======================== We Called The Function of The Used Calender ===================================
            pickDate(requireActivity())


    }


    // ==================================================(Date & Time Picker)=======================================================================
    private fun getDateTimeCalender() {

        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)

    }
    // =======================================(listener must listen to 'this' and context must be passed to the main activity)========================================
     fun pickDate() {
         addDateAndTime.setOnClickListener {
        getDateTimeCalender()
        DatePickerDialog(
            requireActivity(),
            this,
            year,
            month,
            day
        ).show()







    }
}
// For Time Dialog
        @RequiresApi(Build.VERSION_CODES.N)
        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            savedDay = dayOfMonth
            savedMonth = month
            savedYear = year
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->


                timeTo = "$hour:$minute"
                timeToText.text = timeTo

            // here is our first time picker
            }
             val timeToTimePicker =TimePickerDialog(
                context,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()

//    Log.d("second",timeFromText.text.toString())
//    timeToText.text = "$hour:$minute"


    // here to make another time picker we need to make time picker dialog inside a time picker --> like anonymous function **

    //=============================================================()=============================================================================




    val timeFrom = TimePickerDialog(
        context,
        {
        timepicker, hour, minute ->
/// ====================================================================
            timeFrom = "$hour:$minute"
            timeFromText.text = timeFrom
/// =====================================================================
        },
        cal.get(Calendar.HOUR_OF_DAY),
        cal.get(Calendar.MINUTE),
        true
    ).show()
//    Log.d("first",timeToText.text.toString())

        }

/*     *NOTE:*
* use github commits to see the differences
*
*
*
*
* */


    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^(Date & Time Picker)^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
