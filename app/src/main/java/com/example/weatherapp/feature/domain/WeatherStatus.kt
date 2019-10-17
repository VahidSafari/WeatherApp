package com.example.weatherapp.feature.domain

import com.example.weatherapp.feature.ui.WeatherView

data class WeatherStatus(var description: String, var temp:Double){
    fun toWeatherView() = WeatherView(description,temp)
}