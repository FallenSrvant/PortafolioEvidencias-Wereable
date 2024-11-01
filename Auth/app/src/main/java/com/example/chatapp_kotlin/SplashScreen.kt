package com.example.chatapp_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)
        MostrarBienvenida()
    }
    fun MostrarBienvenida(){
        object : CountDownTimer(3000,1000){
            override fun onTick(p0: Long) {
                //TODO("Not yet implemented")
            }

            override fun onFinish() {
                val intent = Intent(applicationContext,  Inicio::class.java)
                startActivity(intent)
                finish()
            }

        }.start()
    }
}