package by.ocheretny.weathertesttask.di

import by.ocheretny.weathertesttask.database.WeatherDatabase
import by.ocheretny.weathertesttask.database.repository.LocalWeatherRepository
import by.ocheretny.weathertesttask.database.repository.MainWeatherRepository
import by.ocheretny.weathertesttask.mappers.response.LocalWeatherMapper
import by.ocheretny.weathertesttask.mappers.response.MainWeatherMapper
import by.ocheretny.weathertesttask.mappers.response.WeatherResponseMapper
import by.ocheretny.weathertesttask.network.WeatherService
import by.ocheretny.weathertesttask.repository.NetworkRepository
import org.koin.dsl.module

val repositoryModule = module {

    fun provideNetworkRepository(
        apiService: WeatherService,
        mapper: WeatherResponseMapper,
        localWeatherMapper: LocalWeatherMapper,
        mainWeatherMapper: MainWeatherMapper,
        dbLocalRepository: LocalWeatherRepository,
        dbMainRepository: MainWeatherRepository
    ): NetworkRepository {
        return NetworkRepository(
            apiService,
            mapper,
            localWeatherMapper,
            mainWeatherMapper,
            dbLocalRepository,
            dbMainRepository
        )
    }

    fun provideMainWeatherRepository(database: WeatherDatabase): MainWeatherRepository {
        return MainWeatherRepository(database.mainWeather())
    }

    fun provideLocalWeatherRepository(database: WeatherDatabase): LocalWeatherRepository {
        return LocalWeatherRepository(database.localWeatherDao())
    }

    single { provideNetworkRepository(get(), get(), get(), get(), get(),get()) }
    single { provideLocalWeatherRepository(get()) }
    single { provideMainWeatherRepository(get()) }

}