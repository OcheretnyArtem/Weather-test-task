package by.ocheretny.weathertesttask.mappers.response

import by.ocheretny.weathertesttask.mappers.Mapper
import by.ocheretny.weathertesttask.network.dto.WeatherResponse
import by.ocheretny.weathertesttask.network.entities.Weather

class WeatherResponseMapper : Mapper<WeatherResponse?, Weather> {
    override fun map(from: WeatherResponse?): Weather {
        return Weather(
            lat = from?.coord?.lat  ?: 0.0,
            lon = from?.coord?.lon  ?: 0.0,
            dt = from?.dt  ?: 0,
            feelsLike = from?.main?.feelsLike  ?: 0.0,
            humidity = from?.main?.humidity  ?: 0,
            pressure = from?.main?.pressure  ?: 0,
            temp = from?.main?.temp  ?: 0.0,
            name = from?.name.orEmpty(),
            visibility = from?.visibility ?: 0,
            windSpeed = from?.wind?.speed ?: 0.0,
            icon = from?.weather?.get(0)?.icon.orEmpty(),
            description = from?.weather?.get(0)?.description.orEmpty(),
        )
    }
}