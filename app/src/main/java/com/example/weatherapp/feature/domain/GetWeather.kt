package com.example.weatherapp.feature.domain

import com.example.weatherapp.feature.data.WeatherRepository


class GetWeather {

    private val weatherRepository = WeatherRepository()

    suspend fun getWeatherStatus(cityName: String) =
        weatherRepository.getWeatherStatus(cityName)

    fun getWeatherStatusFromDB(cityName: String) =
        weatherRepository.getWeatherStatusFromDB(cityName)
}