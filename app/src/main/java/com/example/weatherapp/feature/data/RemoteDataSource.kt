package com.example.weatherapp.feature.data

import com.example.weatherapp.core.api.RetrofitFactory

class RemoteDataSource {
    private val retrofit = RetrofitFactory.getRetrofit()
    private val weatherService =
        retrofit?.create(WeatherService::class.java)

    suspend fun getWeatherStatus(cityName: String) =
        weatherService?.getWeatherStatus(cityName)
}