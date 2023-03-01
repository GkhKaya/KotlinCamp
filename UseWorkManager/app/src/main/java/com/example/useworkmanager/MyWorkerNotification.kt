package com.example.useworkmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkerNotification(appContext:Context,workerParameters: WorkerParameters):Worker(appContext,workerParameters) {
    override fun doWork(): Result {
        return Result.success()
    }

    fun createNotification(){

        val builder:NotificationCompat.Builder
        val notificationAdministrator =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(applicationContext,MainActivity::class.java)
        val destinationIntent = PendingIntent.getActivity(applicationContext,1,intent,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channelId = "channelId"
            val channelName = "channelName"
            val channelDescription = "channelDescription"
            val channelPriority = NotificationManager.IMPORTANCE_HIGH

            var channel : NotificationChannel? = notificationAdministrator.getNotificationChannel(channelId)

            if(channel == null){
                channel = NotificationChannel(channelId,channelName,channelPriority)
                channel.description = channelDescription
                notificationAdministrator.createNotificationChannel(channel)
            }

            builder = NotificationCompat.Builder(applicationContext,channelId)

            builder.setContentTitle("Başlık")
                .setContentText("İçerik")
                .setSmallIcon(R.drawable.image)
                .setContentIntent(destinationIntent)
                .setAutoCancel(true)
        }else{
            builder = NotificationCompat.Builder(applicationContext)

            builder.setContentTitle("Başlık")
                .setContentText("İçerik")
                .setSmallIcon(R.drawable.image)
                .setContentIntent(destinationIntent)
                .setAutoCancel(true)
                .priority = Notification.PRIORITY_HIGH
        }

        notificationAdministrator.notify(1,builder.build())
    }

}