package com.example.weatherapp.feature.domain

import com.example.weatherapp.MainActivity
import com.example.weatherapp.feature.data.WeatherRepository
import javax.inject.Inject


class GetWeather {

    @Inject lateinit var weatherRepository: WeatherRepository

    init {
        MainActivity.dagger.inject(this)
    }

    suspend fun getWeatherStatus(cityName: String) =
        weatherRepository.getWeatherStatus(cityName)

    fun getWeatherStatusFromDB(cityName: String) =
        weatherRepository.getWeatherStatusFromDB(cityName)
}