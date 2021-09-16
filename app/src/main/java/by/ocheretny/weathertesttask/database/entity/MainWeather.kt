package by.ocheretny.weathertesttask.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_weather")
class MainWeather(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val lat: Double,
    val lon: Double,
    val dt: Int,
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val visibility: Int,
    val windSpeed: Double,
    val icon: String,
    val description: String
)