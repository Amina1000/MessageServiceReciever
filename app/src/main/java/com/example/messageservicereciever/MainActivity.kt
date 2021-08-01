package com.example.messageservicereciever

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNotificationChannel()
    }
    // инициализация канала нотификаций
    private fun initNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel("2", "name", importance)
            notificationManager.createNotificationChannel(channel)
        }
    }

}