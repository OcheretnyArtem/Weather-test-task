package by.ocheretny.weathertesttask.network

import by.ocheretny.weathertesttask.network.dto.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("/data/2.5/weather?")
    suspend fun getWeatherByCity(
        @Query("q")
        cityName: String,
        @Query("units")
        units: String,
        @Query("appid")
        appid: String
    ):Response<WeatherResponse>

    @GET("/data/2.5/weather?")
    suspend fun getWeatherByCoordinates(
        @Query("lat")
        lat: Double,
        @Query("lon")
        lon: Double,
        @Query("units")
        units: String,
        @Query("appid")
        appid: String
    ):Response<WeatherResponse>
}