package com.example.app_intents

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        // Obtener los datos del intent
        val sender = intent.getStringExtra("sms_sender")
        val messageBody = intent.getStringExtra("sms_body")

        // Aquí podrías mostrar el mensaje en tu UI
        Log.d("SMS", "Sender: $sender, Message: $messageBody")
    }
}