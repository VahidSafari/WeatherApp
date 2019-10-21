package com.example.weatherapp.feature.data

import com.example.weatherapp.MainActivity
import com.example.weatherapp.core.api.Result
import com.example.weatherapp.core.dagger.DaggerWeatherComponent
import com.example.weatherapp.core.dagger.WeatherModule
import com.example.weatherapp.core.util.NetworkHandler
import javax.inject.Inject

class WeatherRepository {
    @Inject lateinit var remoteDataSource: RemoteDataSource
    @Inject lateinit var localDataSource: LocalDataSource

    init {
        MainActivity.dagger.inject(this)
    }

    fun getWeatherStatusFromDB(cityName: String) = localDataSource.getWeatherStatus(cityName)

    suspend fun getWeatherStatus(cityName: String): String {
        var message = ""
        if (NetworkHandler.hasNetworkConnection()) {
            val result = remoteDataSource.getWeatherStatus(cityName)
                if (result is Result.Success){
                    localDataSource.insertWeatherStatus(result.data.toWeatherStatusEntity())
                } else if (result is Result.Error) {
                    message = result.message
                } else {
                    message = "You are not connected to the Internet."
                }
        } else {
            message = "You are not connected to the Internet."
        }
        return message
    }
}