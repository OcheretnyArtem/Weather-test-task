package by.ocheretny

import android.app.Application
import by.ocheretny.weathertesttask.di.databaseModule
import by.ocheretny.weathertesttask.di.mappersModule
import by.ocheretny.weathertesttask.di.networkModule
import by.ocheretny.weathertesttask.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(networkModule, repositoryModule, mappersModule, databaseModule)
        }
    }
}