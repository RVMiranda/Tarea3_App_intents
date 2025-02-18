package com.example.app_intents

import android.content.Intent
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

        // Obtener el texto compartido desde otras aplicaciones
        val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)

        if (sharedText != null) {
            // Mostrar el texto recibido, por ejemplo en un TextView
            Log.d("SMS", "Texto recibido: $sharedText")
        } else {
            Log.d("SMS", "No se recibió texto")
        }
    }
}
