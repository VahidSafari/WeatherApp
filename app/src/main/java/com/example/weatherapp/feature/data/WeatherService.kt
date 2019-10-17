package com.example.weatherapp.feature.data

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Query

interface WeatherService {

    @GET("/data/2.5/weather")
    suspend fun getWeatherStatus(
        @Query("q") cityName: String,
        @Query("appid") appid: String = "b6907d289e10d714a6e88b30761fae22"
        ): Response<WeatherStatusResponse>
}