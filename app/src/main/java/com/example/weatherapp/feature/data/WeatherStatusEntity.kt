package com.example.weatherapp.feature.data

import androidx.room.Entity
import com.example.weatherapp.feature.ui.WeatherView

@Entity(
    primaryKeys = ["id"]
)
data class WeatherStatusEntity(
    val id: Int,
    val description: String,
    val temp:Double,
    val cityName: String
){
    fun toWeatherView() = WeatherView(description,temp)
}