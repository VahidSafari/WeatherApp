package com.example.weatherapp.feature.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.core.api.Result


class WeatherDomain(private val weatherRepository: WeatherRepository) {

    suspend fun getWeatherStatus(cityName: String):LiveData<WeatherStatusEntity> {
        val ws = weatherRepository.getWeatherStatusFromRemote(cityName)
        return weatherRepository.getWeatherStatusFromLocal(cityName)?:MutableLiveData()
    }

}