package com.example.app_intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener el botón
        val buttonGoToSMS: Button = findViewById(R.id.buttonGoToSMS)

        // Configurar el clic del botón
        buttonGoToSMS.setOnClickListener {
            // Crear un Intent para ir a la actividad SMS
            val intent = Intent(this, SMS::class.java)
            startActivity(intent)
        }
    }
}
