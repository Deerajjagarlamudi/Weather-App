package com.example.weatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    private val apiKey = "e2bcd1882a312df1c1624bd7dd6aaa9d"

    fun getWeather(city: String) {
        viewModelScope.launch {
            try {
                val response = WeatherApiService.create().getWeather(city, apiKey)
                _weatherData.value = response
            } catch (e: Exception) {
            }
        }
    }
}
