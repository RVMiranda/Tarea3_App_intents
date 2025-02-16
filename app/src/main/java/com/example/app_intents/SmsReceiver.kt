package com.example.app_intents

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            val pdus = bundle.get("pdus") as? Array<*>
            if (pdus != null) {
                for (pdu in pdus) {
                    val message = SmsMessage.createFromPdu(pdu as ByteArray)
                    val sender = message.displayOriginatingAddress
                    val body = message.messageBody

                    // Enviar mensaje a la actividad SMS
                    val smsIntent = Intent(context, SMS::class.java)
                    smsIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    smsIntent.putExtra("sms_sender", sender)
                    smsIntent.putExtra("sms_body", body)
                    context.startActivity(smsIntent)
                }
            }
        }
    }
}
