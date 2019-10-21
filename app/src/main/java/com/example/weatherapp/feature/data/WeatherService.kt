package com.example.weatherapp.feature.data

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface WeatherService {

    @GET("/data/2.5/weather")
    suspend fun getWeatherStatus(
        @Query("q") cityName: String,
        @Query("appid") appid: String = "06f4ef7e92e40f76c0f7e9d28c46ab84"
        ): Response<WeatherStatusResponse>
}