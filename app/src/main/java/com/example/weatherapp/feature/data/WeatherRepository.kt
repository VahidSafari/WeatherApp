package com.example.weatherapp.feature.data

import com.example.weatherapp.core.api.Result
import com.example.weatherapp.core.util.NetworkHandler

class WeatherRepository {
    private val remoteDataSource: RemoteDataSource by lazy { RemoteDataSource() }
    private val localDataSource: LocalDataSource by lazy { LocalDataSource() }

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