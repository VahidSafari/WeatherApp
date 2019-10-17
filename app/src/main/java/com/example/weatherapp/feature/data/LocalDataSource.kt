package com.example.weatherapp.feature.data

import androidx.lifecycle.LiveData
import com.example.weatherapp.core.db.WeatherDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalDataSource {
    private val db = WeatherDatabase.getInstance()

    suspend fun insertWeatherStatus(weatherStatusEntity: WeatherStatusEntity) {
        CoroutineScope(Dispatchers.IO).launch{
            db?.getWeatherDao()?.insertWeatherStatus(weatherStatusEntity)
        }
    }

    fun getWeatherStatus(cityName: String): LiveData<WeatherStatusEntity>? {
            return db?.getWeatherDao()?.getWeatherStatus(cityName)
    }
}

