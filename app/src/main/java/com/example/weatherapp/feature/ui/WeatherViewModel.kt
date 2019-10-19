package com.example.weatherapp.feature.ui

import androidx.lifecycle.*
import com.example.weatherapp.feature.domain.GetWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel : ViewModel() {

    private val weatherDomain = GetWeather()
//    private val _weatherStatus = MutableLiveData<WeatherView>()
//    val weatherStatus: LiveData<WeatherView>
//        get() = _weatherStatus

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