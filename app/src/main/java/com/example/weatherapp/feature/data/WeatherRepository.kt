package com.example.weatherapp.feature.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.weatherapp.core.api.Result
import com.example.weatherapp.feature.domain.WeatherStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepository {
    private val remoteDataSource = RemoteDataSource()
    private val localDataSource = LocalDataSource()

//    fun getWeatherStatusFromLocal(cityName: String) = localDataSource.getWeatherStatus(cityName)

    suspend fun getWeatherStatusFromRemote(cityName: String): WeatherStatus? {
        var result: WeatherStatus? = null
        withContext(Dispatchers.IO) {
            val weatherStatusResponse = remoteDataSource.getWeatherStatus(cityName)
            when (weatherStatusResponse?.code()) {
                200 -> {
                    weatherStatusResponse.body()?.let {
                        localDataSource.insertWeatherStatus(
                            it.toWeatherStatusEntity()
                        )
                    }
                }
                401 -> {
                }
                else -> {
                }
            }
            result = localDataSource.getWeatherStatus(cityName)?.value?.toWeatherStatus()
        }
        return result
    }
}