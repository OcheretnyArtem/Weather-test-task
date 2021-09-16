package by.ocheretny.weathertesttask.di

import by.ocheretny.weathertesttask.mappers.response.LocalWeatherMapper
import by.ocheretny.weathertesttask.mappers.response.MainWeatherMapper
import by.ocheretny.weathertesttask.mappers.response.WeatherResponseMapper
import org.koin.dsl.module

val mappersModule = module {

    fun provideWeatherResponseMapper(): WeatherResponseMapper {
        return WeatherResponseMapper()
    }

    fun provideLocalWeatherMapper(): LocalWeatherMapper {
        return LocalWeatherMapper()
    }

    fun provideMainWeatherMapper(): MainWeatherMapper {
        return MainWeatherMapper()
    }

    factory { provideWeatherResponseMapper() }
    factory { provideLocalWeatherMapper() }
    factory { provideMainWeatherMapper() }

}