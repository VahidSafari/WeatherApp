package com.example.weatherapp.feature.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.MainActivity
import com.example.weatherapp.core.db.WeatherDatabase
import javax.inject.Inject

class LocalDataSource {
    @Inject lateinit var db: WeatherDatabase

    init {
        MainActivity.dagger.inject(this)
    }

    suspend fun insertWeatherStatus(weatherStatusEntity: WeatherStatusEntity) {
            db.getWeatherDao().insertWeatherStatus(weatherStatusEntity)
    }

    fun getWeatherStatus(cityName: String): LiveData<WeatherStatusEntity> {
        return db.getWeatherDao().getWeatherStatus(cityName)
    }
}

