package com.example.app_intents

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        // Obtener el texto compartido desde otras aplicaciones
        val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)

        if (sharedText != null) {
            // Mostrar el texto recibido en un TextView
            val textView: TextView = findViewById(R.id.textView)
            textView.text = sharedText

            // Mostrar un Toast con el texto
            Toast.makeText(this, "Texto recibido: $sharedText", Toast.LENGTH_SHORT).show()
        }
    }
}
