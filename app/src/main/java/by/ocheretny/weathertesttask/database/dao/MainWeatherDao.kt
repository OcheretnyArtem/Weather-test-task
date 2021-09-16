package by.ocheretny.weathertesttask.database.dao

import androidx.room.*
import by.ocheretny.weathertesttask.database.entity.MainWeather

@Dao
interface MainWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weather: MainWeather)

    @Delete
    suspend fun delete(weather: MainWeather)

    @Update
    suspend fun update(weather: MainWeather)

    @Query("SELECT * FROM main_weather WHERE id = 1 ")
    suspend fun getMain(): MainWeather
}