package sheridan.wrimicha.assignment3.network

data class WeatherJSON(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)