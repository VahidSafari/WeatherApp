package com.example.weatherapp.feature.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.example.weatherapp.core.api.Result
import com.example.weatherapp.feature.data.WeatherDomain

class WeatherViewModel(private val weatherDomain: WeatherDomain) : ViewModel() {
    //    private var _weatherStatus = MutableLiveData<>
    fun getWeatherStatus(cityName: String) = liveData<WeatherView>(Dispatchers.IO) {
        val ws = weatherDomain.getWeatherStatus(cityName)
        emit(ws.value?.toWeatherView()?:WeatherView(":|",0.0))
    }
}