package by.ocheretny.weathertesttask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.ocheretny.weathertesttask.databinding.ActivityMainBinding
import by.ocheretny.weathertesttask.repository.NetworkRepository
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val nr: NetworkRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setupWithNavController(findNavController(R.id.nav_host_fragment_activity_main))

        lifecycleScope.launch {
            nr.loadAllWeathersByCity(listOf("Minsk","Gomel","Саратов"))
            nr.loadWeatherByCoordinates(1.18, 103.51)
        }
    }
}