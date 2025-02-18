package com.example.app_intents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
    private lateinit var intent: Intent
    private lateinit var irASMS: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // ingrid
        btnEnviarSMS = findViewById(R.id.btn_EnviarSMS)

        btnEnviarSMS.setOnClickListener {
            enviarSMS()
        }

        btnEnviarSMS.setOnClickListener {
            Log.d("DEBUG", "Botón presionado")
            //enviarSMS()
            enviarSMS()
        }

        val buttonGoToSMS: Button = findViewById(R.id.buttonGoToSMS)

        buttonGoToSMS.setOnClickListener{
            val intent = Intent(this, SMS::class.java)
            startActivity(intent)
        }

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Verificar y solicitar permisos de SMS
        if (!checkSmsPermissions()) {
            requestSmsPermissions()
        }
        */
    }

    private fun enviarSMS() {
        intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:9811772979") // Número de teléfono
            putExtra("sms_body", "Hola, este es un mensaje enviado desde mi app.")
        }
        startActivity(intent)
    }



    /*
    // 🔹 Verifica si los permisos ya fueron concedidos
    private fun checkSmsPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED
    }

    // 🔹 Si los permisos no están concedidos, solicitarlos al usuario
    private fun requestSmsPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.SEND_SMS),
            SMS_PERMISSION_CODE
        )
    }

    // 🔹 Maneja la respuesta del usuario cuando se le pide permisos
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == SMS_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permiso denegado. La app no podrá recibir SMS.", Toast.LENGTH_LONG).show()
            }
        }
    }

     */
}
