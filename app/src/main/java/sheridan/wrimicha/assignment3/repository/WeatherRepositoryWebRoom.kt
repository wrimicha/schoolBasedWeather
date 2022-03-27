package sheridan.wrimicha.assignment3.repository

import androidx.room.Entity
import androidx.room.PrimaryKey
import ca.tetervak.flowerdata.database.WeatherDao
import ca.tetervak.flowerdata.database.WeatherEntity
//import sheridan.wrimicha.assignment3.database.FlowerEntity
import sheridan.wrimicha.assignment3.repository.WeatherRepository
import sheridan.wrimicha.assignment3.model.Weather
//import sheridan.wrimicha.assignment3.network.CatalogJson
//import sheridan.wrimicha.assignment3.network.FlowerDataApi
import sheridan.wrimicha.assignment3.network.AllWeatherDataJSON
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import sheridan.wrimicha.assignment3.network.WeatherDataApi
import javax.inject.Inject

class WeatherRepositoryWebRoom @Inject constructor(
    private val weatherDao: WeatherDao
) : WeatherRepository {

//    override fun getAll(): Flow<Weather> = weatherDao.getAll()

    override fun get(location: String): Flow<Weather> =
        weatherDao.get(location)
            .map { entity -> entity.asWeather() }
            .flowOn(Dispatchers.IO)

    override suspend fun refresh() {
        val trafalgarWeather: AllWeatherDataJSON = WeatherDataApi.retrofitService.getTrafalgarWeather()
        weatherDao.insert(trafalgarWeather.asEntity("trafalgar"))
    }

//    override suspend fun clear() {
//        flowerDao.deleteAll()
//
}

fun WeatherEntity.asWeather() =
    Weather(
        location = location,
        description = description,
        temp = temp,
        temp_max = temp_max,
        temp_min = temp_min,
        feels_like = feels_like,
        humidity = humidity,
        pressure = pressure
    )


fun AllWeatherDataJSON.asEntity(location: String) =
    WeatherEntity(
        location = location,
        description = weather[0].description,
        temp = main.temp,
        temp_max = main.temp_max,
        temp_min = main.temp_min,
        feels_like = main.feels_like,
        humidity = main.humidity,
        pressure = main.pressure
    )