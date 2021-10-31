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


class LoginFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val userNameEditText: EditText? = view?.findViewById(R.id.username_edit_textview_login)
        val passwadEditText: EditText? = view?.findViewById(R.id.passward_edit_textview_login)
        val loginButton: Button? = view?.findViewById(R.id.signin_button_login)
        val registerButton: Button? = view?.findViewById(R.id.register_button_register)


        loginButton?.setOnClickListener {
            val username = userNameEditText?.text.toString()
            val passward = passwadEditText?.text.toString()

        }

        registerButton?.setOnClickListener {


            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }
}