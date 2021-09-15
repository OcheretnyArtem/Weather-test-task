package by.ocheretny.weathertesttask.repository

import by.ocheretny.weathertesttask.mappers.response.WeatherResponseMapper
import by.ocheretny.weathertesttask.network.WeatherService
import by.ocheretny.weathertesttask.network.entities.Weather

const val API_KEY = "47a0c2a7fd428fe9974cab8565335f85"
const val UNITS = "metric"

class NetworkRepository(
    val api: WeatherService,
    val responseMapper: WeatherResponseMapper
) {

    suspend fun loadWeatherByCity(cityName: String): Weather? {

        val request = api.getWeatherByCity(cityName, UNITS, API_KEY)

        if (request.isSuccessful) {
            return request.body()?.let { responseMapper.map(it) }
        } else throw Throwable(
            request.errorBody().toString()
        )
    }

    suspend fun loadWeatherByCoordinates(lat: Double, lon: Double): Weather? {

        val request = api.getWeatherByCoordinates(lat, lon, UNITS, API_KEY)

        if (request.isSuccessful) {
            return request.body()?.let { responseMapper.map(it) }
        } else throw Throwable(
            request.errorBody().toString()
        )
    }
}