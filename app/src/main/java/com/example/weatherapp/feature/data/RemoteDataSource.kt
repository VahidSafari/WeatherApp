package com.example.weatherapp.feature.data

import com.example.weatherapp.core.api.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.weatherapp.core.api.Result

class RemoteDataSource {
    private val retrofit = RetrofitFactory.getRetrofit()
    private val weatherService =
        retrofit?.create(WeatherService::class.java)

    suspend fun getWeatherStatus(cityName: String): Result<WeatherStatusResponse>? {
        var result : Result<WeatherStatusResponse>? = null
        withContext(Dispatchers.IO){
            val asyncCall = weatherService?.getWeatherStatus(cityName)
            try {
                when(asyncCall?.code()){
                    200 -> {
                        asyncCall.body()?.let {
                            result = Result.Success(it)
                        }
                    }
                    401 -> {
                        result = Result.Error(asyncCall.errorBody().toString())
                    }
                    else -> {
                        result = Result.Error("Server unresponsive")
                    }
                }
            } catch (exception:Exception) {
                exception.printStackTrace()
            }
        }
        return result
    }
}