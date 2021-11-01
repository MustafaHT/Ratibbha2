package com.example.ratibbha.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ratibbha.R


class RegisterFragment : Fragment() {


    // sharedPreferences used to get the data from the file to the register window
    private lateinit var sharedPreferences: SharedPreferences

    // editor used to get sign the data
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


// /\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\
// ======================================()==============================================================================

        // here we are gonna get the data from 'Auth' file that we registered
        sharedPreferences = requireActivity().getSharedPreferences("Auth", Context.MODE_PRIVATE)

        //
        editor = sharedPreferences.edit()

        val userNameEditText: EditText? = view?.findViewById(R.id.username_edit_textview_register)
        val passwordEditText: EditText? = view?.findViewById(R.id.passward_edit_textview_register)
        val emailEditText: EditText? = view?.findViewById(R.id.email_edit_textview_register)
        val registerButton: Button? = view?.findViewById(R.id.register_button_register)

        ///\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\
// ===========================================(Register Button Part)========================================================================

// here we used setOnClickListener so whenever we Click on the button we will transfer back to the login fragment
        registerButton?.setOnClickListener {
            val username = userNameEditText?.text.toString()
            val email = emailEditText?.text.toString()
            val password = passwordEditText?.text.toString()


            editor.putString("username", username)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.commit()
            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {

                Toast.makeText(context, "All information must be filled", Toast.LENGTH_SHORT).show()
            } else {

                // by using findNavController
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
    }
// /\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\//\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
// =============================================()============================================================

    }
