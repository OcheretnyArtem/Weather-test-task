package by.ocheretny.weathertesttask.database.repository

import by.ocheretny.weathertesttask.database.dao.MainWeatherDao
import by.ocheretny.weathertesttask.database.entity.MainWeather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainWeatherRepository(private val dao: MainWeatherDao) {

    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(weather: MainWeather) {
        ioScope.launch {
            dao.insert(weather)
        }
    }

    fun delete(weather: MainWeather) {
        ioScope.launch {
            dao.delete(weather)
        }
    }

    fun update(weather: MainWeather) {
        ioScope.launch {
            dao.update(weather)
        }
    }

    suspend fun getMain(): MainWeather {
        return withContext(ioScope.coroutineContext) {
            dao.getMain()
        }
    }
}