package by.ocheretny.weathertesttask.mappers.response

import by.ocheretny.weathertesttask.mappers.Mapper
import by.ocheretny.weathertesttask.network.dto.WeatherResponse
import by.ocheretny.weathertesttask.network.entities.Weather

class WeatherResponseMapper : Mapper<WeatherResponse, Weather> {
    override fun map(from: WeatherResponse): Weather {
        return Weather(
            lat = from.coord?.lat,
            lon = from.coord?.lon,
            dt = from.dt,
            feelsLike = from.main?.feelsLike,
            humidity = from.main?.humidity,
            pressure = from.main?.pressure,
            temp = from.main?.temp,
            name = from.name,
            visibility = from.visibility,
            windSpeed = from.wind?.speed,
            icon = from.weather?.get(0)?.icon.orEmpty(),
            description = from.weather?.get(0)?.description.orEmpty(),
        )
    }
}