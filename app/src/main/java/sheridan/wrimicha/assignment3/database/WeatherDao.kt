package ca.tetervak.flowerdata.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

//    @Query("SELECT * FROM weather")
//    fun getAll(): Flow<WeatherEntity>

    @Query("SELECT * FROM weather WHERE location = :location")
    fun get(location: String): Flow<WeatherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherEntity: WeatherEntity)

    @Query("DELETE FROM weather")
    suspend fun deleteAll()
}