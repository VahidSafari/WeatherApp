package com.example.weatherapp.feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.weatherapp.feature.domain.GetWeather

class WeatherViewModel : ViewModel() {
    private val weatherDomain = GetWeather()
    fun getWeatherStatus(cityName: String) = liveData<WeatherView>(Dispatchers.IO) {
        val ws = weatherDomain.getWeatherStatus(cityName)
        emit(ws?.toWeatherView()?:WeatherView("Not found :(",0.0))
    }
}