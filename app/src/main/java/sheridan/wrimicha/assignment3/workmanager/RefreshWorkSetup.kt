package ca.tetervak.flowerdata.workmanager

import android.content.Context
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit

fun setupRefreshWork(context: Context) {

    val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED)
        .setRequiresCharging(false)
        .setRequiresBatteryNotLow(true)
        .build()

    // it is not allowed be more often than every 15 min
    val repeatingRequest = PeriodicWorkRequestBuilder<RefreshWorker>(
        repeatInterval = 15,
        TimeUnit.MINUTES
    ).setConstraints(constraints).build()

    WorkManager.getInstance(context).enqueueUniquePeriodicWork(
        RefreshWorker.WORK_NAME,
        ExistingPeriodicWorkPolicy.KEEP,
        repeatingRequest
    )

    WorkManager.getInstance(context).enqueue(OneTimeWorkRequestBuilder<RefreshWorker>().build())

}