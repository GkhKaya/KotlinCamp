package com.example.useworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext: Context,workerParams:WorkerParameters):Worker(appContext,workerParams) {

    override fun doWork(): Result {
        val total = 10+20
        Log.e("Result ",total.toString())
        return Result.success()
    }
}