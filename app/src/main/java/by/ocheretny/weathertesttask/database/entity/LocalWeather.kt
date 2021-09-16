package by.ocheretny.weathertesttask.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class LocalWeather(
    @PrimaryKey(autoGenerate = false)
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