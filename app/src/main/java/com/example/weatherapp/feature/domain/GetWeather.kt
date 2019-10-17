package com.example.weatherapp.feature.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.feature.data.WeatherRepository
import com.example.weatherapp.feature.data.WeatherStatusEntity


class GetWeather {

    private val weatherRepository = WeatherRepository()
    suspend fun getWeatherStatus(cityName: String):WeatherStatus? {
        return weatherRepository.getWeatherStatusFromRemote(cityName)
    }

}