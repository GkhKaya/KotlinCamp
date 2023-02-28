package com.example.situationalnotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNotice.setOnClickListener{
            val builder :NotificationCompat.Builder

            val notificationAdministrator = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val myIntent = Intent(this,MainActivity::class.java)

            val toGoIntent = PendingIntent.getActivities(this,1, arrayOf(myIntent),PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

                val channelId="channelId"
                val channelName="channelName"
                val channelPresentation="channelPresentation"
                val channelPriority=NotificationManager.IMPORTANCE_HIGH

                var channel : NotificationChannel?=notificationAdministrator.getNotificationChannel(channelId)
                if (channel==null){
                    channel = NotificationChannel(channelId,channelName,channelPriority)
                    channel.description=channelPresentation
                    notificationAdministrator.createNotificationChannel(channel)
                }



                builder = NotificationCompat.Builder(this,channelId)
                builder.setContentTitle("Title")
                    .setContentText("Text")
                    .setContentText("Text")
                    .setSmallIcon(R.drawable.image)
                    .setContentIntent(toGoIntent)
                    .setAutoCancel(true)

            }else{
                builder = NotificationCompat.Builder(this)
                    builder.setContentTitle("Title")
                    .setContentText("Text")
                    .setContentText("Text")
                    .setSmallIcon(R.drawable.image)
                    .setContentIntent(toGoIntent)
                    .setAutoCancel(true)
                    .priority = Notification.PRIORITY_HIGH
            }

            notificationAdministrator.notify(1,builder.build())
        }
    }
}