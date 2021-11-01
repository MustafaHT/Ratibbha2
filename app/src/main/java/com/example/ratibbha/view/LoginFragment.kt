package com.example.ratibbha.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ratibbha.R


class LoginFragment : Fragment() {


    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getSharedPreferences("Auth", Context.MODE_PRIVATE)


        val userNameEditText: EditText? = view?.findViewById(R.id.username_edit_textview_login)
        val passwordEditText: EditText? = view?.findViewById(R.id.passward_edit_textview_login)
        val loginButton: Button? = view?.findViewById(R.id.signin_button_login)
        val registerButton: Button? = view?.findViewById(R.id.register_button_register)


        loginButton?.setOnClickListener {
            val username = userNameEditText?.text.toString()
            val password = passwordEditText?.text.toString()

// condition to not transfer with out using the username or the the password
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    context,
                    "Please Enter your password and your username",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                if (username.equals(sharedPreferences.getString("username", "")) && password.equals(
                        sharedPreferences.getString("password", "")
                    )
                ) {
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

                }

            }
        }
            registerButton?.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
    }
}