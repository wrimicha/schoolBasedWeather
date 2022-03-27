package ca.tetervak.flowerdata.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(

    @PrimaryKey
    val location: String,
    val description: String,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int
)