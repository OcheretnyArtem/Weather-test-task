package by.ocheretny.weathertesttask.mappers.response

import by.ocheretny.weathertesttask.database.entity.LocalWeather
import by.ocheretny.weathertesttask.mappers.Mapper
import by.ocheretny.weathertesttask.network.entities.Weather

class LocalWeatherMapper : Mapper<Weather, LocalWeather> {
    override fun map(from: Weather?): LocalWeather {
        return LocalWeather(
            name = from?.name.orEmpty(),
            lat = from?.lat ?: 0.0,
            lon = from?.lon ?: 0.0,
            dt = from?.dt ?: 0,
            feelsLike = from?.feelsLike ?: 0.0,
            humidity = from?.humidity ?: 0,
            pressure = from?.pressure ?: 0,
            temp = from?.temp ?: 0.0,
            visibility = from?.visibility ?: 0,
            windSpeed = from?.windSpeed ?: 0.0,
            icon = from?.icon.orEmpty(),
            description = from?.description.orEmpty(),
        )
    }
}