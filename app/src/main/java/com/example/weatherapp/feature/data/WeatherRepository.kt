package com.example.weatherapp.feature.data

import com.example.weatherapp.core.api.Result

class WeatherRepository {
    private val remoteDataSource = RemoteDataSource()
    private val localDataSource = LocalDataSource()

    fun getWeatherStatusFromLocal(cityName: String) = localDataSource.getWeatherStatus(cityName)

    suspend fun getWeatherStatusFromRemote(cityName: String): Result<String>?{
        var result : Result<String>? = null
        when(val weatherStatusResponse = remoteDataSource.getWeatherStatus(cityName)){
                is Result.Success -> {
                    localDataSource.insertWeatherStatus(weatherStatusResponse.data.toWeatherStatusEntity())
                    result = Result.Success(weatherStatusResponse.data.id.toString())
                }
                is Result.Error -> {
                    result = Result.Error(weatherStatusResponse.message)
                }
            }
        return result
    }

}