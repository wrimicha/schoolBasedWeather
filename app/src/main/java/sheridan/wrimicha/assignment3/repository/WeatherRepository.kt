package sheridan.wrimicha.assignment3.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import sheridan.wrimicha.assignment3.model.Weather

interface WeatherRepository {
    fun get(location: String): Flow<Weather>
//    fun getAll(): Flow<Weather>
    suspend fun refresh()
//    suspend fun clear()
}