package com.example.ratibbha.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ratibbha.R

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val mainFragment = supportFragmentManager.findFragmentById(R.id.app_logo)

        if (mainFragment == null){

        }


    }
}