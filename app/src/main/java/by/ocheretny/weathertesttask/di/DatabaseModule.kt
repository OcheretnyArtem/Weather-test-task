package by.ocheretny.weathertesttask.di

import android.app.Application
import by.ocheretny.weathertesttask.database.WeatherDatabase
import by.ocheretny.weathertesttask.database.repository.LocalWeatherRepository
import by.ocheretny.weathertesttask.database.repository.MainWeatherRepository
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application):WeatherDatabase{
        return WeatherDatabase.getWeatherDatabase(application)
    }

    single { provideDatabase(get()) }

}