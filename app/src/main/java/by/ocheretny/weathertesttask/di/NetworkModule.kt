package by.ocheretny.weathertesttask.di

import by.ocheretny.weathertesttask.BuildConfig
import by.ocheretny.weathertesttask.mappers.response.WeatherResponseMapper
import by.ocheretny.weathertesttask.network.WeatherService
import by.ocheretny.weathertesttask.repository.NetworkRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule = module {

    fun provideOkHttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    fun provideEmployeeWeather(client: OkHttpClient): WeatherService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .baseUrl("https://api.openweathermap.org/")
            .client(client)
            .build()
            .create()
    }

    fun provideWeatherResponseMapper(): WeatherResponseMapper {
        return WeatherResponseMapper()
    }

    fun provideNetworkRepository(
        apiService: WeatherService,
        mapper: WeatherResponseMapper
    ): NetworkRepository {
        return NetworkRepository(apiService, mapper)
    }

    single { provideOkHttpInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideEmployeeWeather(get()) }
    single { provideWeatherResponseMapper() }
    single { provideNetworkRepository(get(), get()) }
}