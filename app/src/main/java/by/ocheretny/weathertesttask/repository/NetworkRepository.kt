package by.ocheretny.weathertesttask.repository

import by.ocheretny.weathertesttask.database.entity.LocalWeather
import by.ocheretny.weathertesttask.database.repository.LocalWeatherRepository
import by.ocheretny.weathertesttask.database.repository.MainWeatherRepository
import by.ocheretny.weathertesttask.mappers.response.LocalWeatherMapper
import by.ocheretny.weathertesttask.mappers.response.MainWeatherMapper
import by.ocheretny.weathertesttask.mappers.response.WeatherResponseMapper
import by.ocheretny.weathertesttask.network.WeatherService
import by.ocheretny.weathertesttask.network.dto.WeatherResponse
import by.ocheretny.weathertesttask.network.entities.Weather
import retrofit2.Response

const val API_KEY = "47a0c2a7fd428fe9974cab8565335f85"
const val UNITS = "metric"

class NetworkRepository(
    private val api: WeatherService,
    private val responseMapper: WeatherResponseMapper,
    private val dbMapperLocal: LocalWeatherMapper,
    private val dbMapperMain: MainWeatherMapper,
    private val dbLocalRepository: LocalWeatherRepository,
    private val dbMainRepository: MainWeatherRepository
) {

    suspend fun loadAllWeathersByCity(cityNames: List<String>) {
        cityNames.forEach { cityName ->
            val request = api.getWeatherByCity(cityName, UNITS, API_KEY)
            dbLocalRepository.insert(dbMapperLocal.map(loader(request)))
        }
    }

    suspend fun loadWeatherByCity(cityName: String): Weather {
        val request = api.getWeatherByCity(cityName, UNITS, API_KEY)
        return (loader(request))
    }

    suspend fun loadWeatherByCoordinates(lat: Double, lon: Double) {
        val request = api.getWeatherByCoordinates(lat, lon, UNITS, API_KEY)
        dbMainRepository.insert(dbMapperMain.map(loader(request)))
    }

    private fun loader(request: Response<WeatherResponse>): Weather {
        if (request.isSuccessful) {
            return responseMapper.map(request.body())
        } else throw Throwable(
            request.errorBody().toString()
        )
    }
}