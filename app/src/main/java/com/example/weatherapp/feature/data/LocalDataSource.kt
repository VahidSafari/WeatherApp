package com.example.weatherapp.feature.data

import com.example.weatherapp.core.db.WeatherDatabase

class LocalDataSource {
    private val db = WeatherDatabase.getInstance()

    suspend fun insertWeatherStatus(weatherStatusEntity: WeatherStatusEntity) {
        db?.getWeatherDao()?.insertWeatherStatus(weatherStatusEntity)
    }

    fun getWeatherStatus(cityName: String) =
        db?.getWeatherDao()?.getWeatherStatus(cityName)
}