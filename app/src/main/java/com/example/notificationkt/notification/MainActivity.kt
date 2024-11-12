package com.example.notificationkt.notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.notificationkt.R
import com.example.notificationkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel()

        binding.btnNotification.setOnClickListener {
            showNotification()
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "noti"
            val channelDescription = "notiDes"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel("notification", channelName, importance).apply {
                description = channelDescription
            }

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    @SuppressLint("RemoteViewLayout")
    private fun showNotification() {
        val notificationManager = getSystemService(NotificationManager::class.java)

        val notificationId = 1
        val customView = RemoteViews(packageName, R.layout.custom_notification)

        customView.setTextViewText(R.id.custom_notification_title, "E2Logy Software Solutions")
        customView.setTextViewText(
            R.id.custom_notification_message,
            "Mobile/Web Software development company"
        )
        customView.setImageViewResource(R.id.custom_notification_icon, R.drawable.food)
        customView.setTextViewText(R.id.txtSumit, "Sumit Panchal")

        val builder = NotificationCompat.Builder(this, "notification")
            .setSmallIcon(R.drawable.notification)
            .setCustomContentView(customView)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        notificationManager.notify(notificationId, builder.build())
    }
}
