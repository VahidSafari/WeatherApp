package com.example.weatherapp.feature.data

import retrofit2.http.GET
import retrofit2.http.Path
import com.example.weatherapp.core.api.Result
interface WeatherService {

    @GET("/weather?q={cityName}")
    suspend fun getWeatherStatus(
        @Path("cityName") cityName: String
    ):Result<WeatherStatusResponse>
}