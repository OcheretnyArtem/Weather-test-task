package by.ocheretny.weathertesttask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.ocheretny.weathertesttask.database.dao.LocalWeatherDao
import by.ocheretny.weathertesttask.database.dao.MainWeatherDao
import by.ocheretny.weathertesttask.database.entity.LocalWeather
import by.ocheretny.weathertesttask.database.entity.MainWeather

@Database(entities = [LocalWeather::class,MainWeather::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun localWeatherDao(): LocalWeatherDao
    abstract fun mainWeather(): MainWeatherDao

    companion object {

        var INSTANCE: WeatherDatabase? = null

        fun getWeatherDatabase(context: Context): WeatherDatabase {
            return if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, WeatherDatabase::class.java, "database").build()
                INSTANCE as WeatherDatabase
            } else INSTANCE as WeatherDatabase
        }
    }
}