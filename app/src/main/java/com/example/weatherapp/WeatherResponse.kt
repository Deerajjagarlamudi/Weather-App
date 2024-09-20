package com.example.weatherapp

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>,
    val name: String
)

data class Main(val temp: Double)
data class Weather(val description: String)