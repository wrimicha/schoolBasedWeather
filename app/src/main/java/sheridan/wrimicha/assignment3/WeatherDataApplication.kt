package sheridan.wrimicha.assignment3

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.*
import ca.tetervak.flowerdata.workmanager.setupRefreshWork
//import sheridan.wrimicha.assignment3.workmanager.setupRefreshWork
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import sheridan.wrimicha.assignment3.repository.WeatherRepository
import javax.inject.Inject

@HiltAndroidApp
class WeatherDataApplication: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    @Inject
    lateinit var repository: WeatherRepository

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        runBlocking {
            repository.refresh()
        }

        setupRefreshWork(this)
    }

}