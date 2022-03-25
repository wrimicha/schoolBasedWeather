package sheridan.wrimicha.assignment3.network

data class AllWeatherDataJSON(
    val base: String,
    val clouds: CloudsJSON,
    val cod: Int,
    val coord: CoordJSON,
    val dt: Int,
    val id: Int,
    val main: MainJSON,
    val name: String,
    val sys: SysJSON,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherJSON>,
    val wind: WindJSON
)