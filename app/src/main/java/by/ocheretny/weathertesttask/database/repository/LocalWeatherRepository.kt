package by.ocheretny.weathertesttask.database.repository

import by.ocheretny.weathertesttask.database.dao.LocalWeatherDao
import by.ocheretny.weathertesttask.database.entity.LocalWeather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocalWeatherRepository(private val dao: LocalWeatherDao) {

    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(weather: LocalWeather) {
        ioScope.launch {
            dao.insert(weather)
        }
    }

    fun delete(weather: LocalWeather) {
        ioScope.launch {
            dao.delete(weather)
        }
    }

    fun update(weather: LocalWeather) {
        ioScope.launch {
            dao.update(weather)
        }
    }

    suspend fun getAll(): List<LocalWeather> {
        return withContext(ioScope.coroutineContext) {
            dao.getAll()
        }
    }

    suspend fun getByCity(city: String): LocalWeather {
        return withContext(ioScope.coroutineContext) {
            dao.getByCity(city)
        }
    }

}