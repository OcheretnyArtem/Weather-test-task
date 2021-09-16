package by.ocheretny.weathertesttask.database.dao

import androidx.room.*
import by.ocheretny.weathertesttask.database.entity.LocalWeather

@Dao
interface LocalWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weather: LocalWeather)

    @Delete
    suspend fun delete(weather: LocalWeather)

    @Update
    suspend fun update(weather: LocalWeather)

    @Query("SELECT * FROM weather WHERE name LIKE :city")
    suspend fun getByCity(city:String):LocalWeather

    @Query("SELECT * FROM weather ")
    suspend fun getAll():List<LocalWeather>
}