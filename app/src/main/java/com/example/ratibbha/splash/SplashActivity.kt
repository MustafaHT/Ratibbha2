package com.example.ratibbha.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.ratibbha.view.MainActivity
import com.example.ratibbha.R

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splash = Intent(this, MainActivity::class.java)
        object : CountDownTimer(4000,1000){

            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                startActivity(splash)
            }

        }.start()




    }
}