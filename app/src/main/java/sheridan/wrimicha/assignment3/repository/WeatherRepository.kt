package sheridan.wrimicha.assignment3.repository

import androidx.lifecycle.LiveData
import sheridan.wrimicha.assignment3.model.Weather

interface WeatherRepository {
    fun get(): LiveData<Weather>
}