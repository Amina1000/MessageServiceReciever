package com.example.messageservicereciever

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat

const val TAG = "MessageBroadcastReceiver"
const val NAME_MSG = "MSG"

class MessageServiceReceiver : BroadcastReceiver() {

    private var messageId = 0
    @SuppressLint("LongLogTag")
    override fun onReceive(context: Context, intent: Intent) {
        // Получить параметр сообщения
        var message = intent.getStringExtra(NAME_MSG)
        if (message == null) {
            message = ""
        }
        Log.d(TAG, message)
        // создать нотификацию
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, "2")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Broadcast Receiver")
            .setContentText(message)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(messageId++, builder.build())
    }
}