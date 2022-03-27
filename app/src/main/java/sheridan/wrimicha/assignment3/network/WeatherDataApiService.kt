package sheridan.wrimicha.assignment3.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(JSON_BASE_URL)
    .build()

interface WeatherDataApiService {
    @GET("2.5/weather?lat=43.46909742475904&lon=-79.70006256015566&appid=43936a51edf878b2a70d6b0e00ac3091")
    suspend fun getTrafalgarWeather(): AllWeatherDataJSON

    @GET("2.5/weather?lat=43.46909742475904&lon=-79.70006256015566&appid=43936a51edf878b2a70d6b0e00ac3091")
    suspend fun getDavisWeather(): AllWeatherDataJSON
}

object WeatherDataApi {
    val retrofitService : WeatherDataApiService by lazy {
        retrofit.create(WeatherDataApiService::class.java) }
}

