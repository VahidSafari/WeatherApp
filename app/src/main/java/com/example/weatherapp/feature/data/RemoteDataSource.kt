package com.example.weatherapp.feature.data

import com.example.weatherapp.core.api.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteDataSource {
    private val retrofit = RetrofitFactory.getRetrofit()
    private val weatherService =
        retrofit?.create(WeatherService::class.java)

    suspend fun getWeatherStatus(cityName: String): Response<WeatherStatusResponse>? {
        var response : Response<WeatherStatusResponse>? = null
        withContext(Dispatchers.IO){
            weatherService?.getWeatherStatus(cityName)?.let {
                response = it
            }
        }
        return response
    }
}