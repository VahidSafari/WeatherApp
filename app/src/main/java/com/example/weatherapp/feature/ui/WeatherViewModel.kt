package com.example.weatherapp.feature.ui

import androidx.lifecycle.*
import com.example.weatherapp.MainActivity
import com.example.weatherapp.feature.domain.GetWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherViewModel : ViewModel() {

    @Inject lateinit var weatherDomain: GetWeather

    init {
        MainActivity.dagger.inject(this)
    }

    fun getWeatherStatusDB(cityName: String) = liveData {
        emitSource(weatherDomain.getWeatherStatusFromDB(cityName))
    }

    fun getWeatherStatus(cityName: String):String {
        var message = ""
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                message = weatherDomain.getWeatherStatus(
                    cityName
                )
            }
        }
        return message
    }
}