package com.example.ratibbha.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.ratibbha.R


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val userNameEditText: EditText? = view?.findViewById(R.id.username_edit_textview_register)
        val passwardEditText: EditText? = view?.findViewById(R.id.passward_edit_textview_register)
        val emailEditText: EditText? = view?.findViewById(R.id.email_edit_textview_register)
        val registerButton: Button? = view?.findViewById(R.id.register_button_register)

        ///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
//===========================================(Register Button Part)========================================================================

// here we used setOnClickListener so whenever we Click on the button we will transfer back to the login fragment
        registerButton?.setOnClickListener {
            val username = userNameEditText?.text.toString()
            val email = emailEditText?.text.toString()
            val passward = passwardEditText?.text.toString()

            // by using findNavController
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
// /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
// =============================================()============================================================




    }
}