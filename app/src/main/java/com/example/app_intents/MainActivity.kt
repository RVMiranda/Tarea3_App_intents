package com.example.app_intents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val SMS_PERMISSION_CODE = 101
    private lateinit var btnEnviarSMS: Button
    private lateinit var btnCompartir: Button
    private lateinit var intent: Intent
    private lateinit var buttonGoToImageView: Button
    private lateinit var Textbox_editable: EditText
    private lateinit var Textbox_editable2: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // ingrid
        btnEnviarSMS = findViewById(R.id.btn_EnviarSMS)
        btnCompartir = findViewById(R.id.btn_Compartir)
        Textbox_editable = findViewById(R.id.Textbox_editable)
        Textbox_editable2 = findViewById(R.id.Textbox_editable_num)
        buttonGoToImageView = findViewById(R.id.buttonGoToImageView)

        btnCompartir.setOnClickListener {
            compartir()
        }

        btnEnviarSMS.setOnClickListener {
            enviarSMS()
        }

        val buttonGoToSMS: Button = findViewById(R.id.buttonGoToSMS)

        buttonGoToSMS.setOnClickListener{
            val intent = Intent(this, SMS::class.java)
            startActivity(intent)
        }

        buttonGoToImageView.setOnClickListener {
            val intent = Intent(this, Activity_Camara::class.java)
            startActivity(intent)
        }
    }

    private fun enviarSMS() {
        intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:${Textbox_editable2.text}") // Número de teléfono
            putExtra("sms_body", "${Textbox_editable.text}")
        }
        startActivity(intent)
    }

    private fun compartir() {
        // Obtener el texto del EditText
        val textoParaCompartir = Textbox_editable.text.toString()

        // Verificar si el texto no está vacío
        if (textoParaCompartir.isNotEmpty()) {
            // Crear un Intent de tipo SEND
            val shareIntent = Intent(Intent.ACTION_SEND)

            // Especificar el tipo de contenido como texto plano
            shareIntent.type = "text/plain"

            // Agregar el texto que queremos compartir
            shareIntent.putExtra(Intent.EXTRA_TEXT, textoParaCompartir)

            // Crear un chooser para que el usuario elija la aplicación
            val chooser = Intent.createChooser(shareIntent, "Compartir con...")

            // Iniciar el chooser
            startActivity(chooser)
        } else {
            // Mostrar un Toast si el texto está vacío
            Toast.makeText(this, "Por favor ingresa un texto para compartir.", Toast.LENGTH_SHORT).show()
        }
    }
}
