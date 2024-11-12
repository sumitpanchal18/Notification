package com.example.notificationkt.service

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.notificationkt.R

class ServiceActivity : AppCompatActivity() {

    lateinit var start: Button
    lateinit var stop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        start = findViewById(R.id.startButton)
        stop = findViewById(R.id.stopButton)

        start.setOnClickListener {
            startService(Intent(this, NewService::class.java))
        }
        stop.setOnClickListener {
            stopService(Intent(this, NewService::class.java))
        }
    }

}
