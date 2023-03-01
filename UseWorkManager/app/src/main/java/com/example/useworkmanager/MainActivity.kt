package com.example.useworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import com.example.useworkmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var  design:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design=ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.buttonMake.setOnClickListener{
//            val workingCondition = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED0).build()
//            val request = OneTimeWorkRequestBuilder<MyWorker>()
//                .setInitialDelay(10, TimeUnit.SECONDS)
//                .setConstraints(workingCondition)
//                .build()
//            WorkManager.getInstance(this).enqueue(request)

            val request = PeriodicWorkRequestBuilder<MyWorkerNotification>(15,TimeUnit.MINUTES)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build()

            WorkManager.getInstance(this).enqueue(request)

            WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this){
                val situation = it.state.name
                Log.e("Background ",situation)
            }
        }
    }
}