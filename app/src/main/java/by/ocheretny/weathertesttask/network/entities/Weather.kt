package by.ocheretny.weathertesttask.network.entities

data class Weather(
    val lat: Double?,
    val lon: Double?,
    val dt: Int?,
    val feelsLike: Double?,
    val humidity: Int?,
    val pressure: Int?,
    val temp: Double?,
    val name: String?,
    val visibility: Int?,
    val windSpeed: Double?,
    val icon: String?,
    val description: String?
)