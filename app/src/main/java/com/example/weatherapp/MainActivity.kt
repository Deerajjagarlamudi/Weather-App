package com.example.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.weatherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSearch.setOnClickListener {
            val city = binding.editTextCity.text.toString()
            viewModel.getWeather(city)
        }

        viewModel.weatherData.observe(this, Observer { weatherResponse ->
            weatherResponse?.let {
                binding.textViewWeather.text = "${it.name}: ${it.main.temp}°C, ${it.weather[0].description}"
            } ?: run {
                binding.textViewWeather.text = "Error fetching weather data"
            }
        })
    }
}
