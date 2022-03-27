package ca.tetervak.flowerdata.workmanager

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import sheridan.wrimicha.assignment3.repository.WeatherRepository

@HiltWorker
class RefreshWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted params: WorkerParameters,
    private val repository: WeatherRepository
) : CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "sheridan.wrimicha.assignment3.workmanager.RefreshWorker"
        const val MAX_ATTEMPT_COUNT = 3
    }
    override suspend fun doWork(): Result {
        try {
            repository.refresh()
            Log.d("Hello", "try")
        } catch (e: HttpException) {
            Log.d("Hello", e.message())
            return if(runAttemptCount < MAX_ATTEMPT_COUNT){
                Result.retry()
            }else{
                Result.failure()
            }
        }

        return Result.success()
    }


}