package sheridan.wrimicha.assignment3.model

data class Weather(
    val location: String,
    val description: String,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int
)