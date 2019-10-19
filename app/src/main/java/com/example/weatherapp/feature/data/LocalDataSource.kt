package com.example.weatherapp.feature.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.core.db.WeatherDatabase

class LocalDataSource {
    private val db = WeatherDatabase.getInstance()

    suspend fun insertWeatherStatus(weatherStatusEntity: WeatherStatusEntity) {
            db?.getWeatherDao()?.insertWeatherStatus(weatherStatusEntity)
    }

    fun getWeatherStatus(cityName: String): LiveData<WeatherStatusEntity> {
        return db?.getWeatherDao()?.getWeatherStatus(cityName)?:MutableLiveData()
    }
}

