package com.example.weatherapp.core.dagger

import com.example.weatherapp.feature.data.LocalDataSource
import com.example.weatherapp.feature.data.RemoteDataSource
import com.example.weatherapp.feature.data.WeatherRepository
import com.example.weatherapp.feature.data.WeatherService
import com.example.weatherapp.feature.domain.GetWeather
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
class WeatherModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource() = RemoteDataSource()

    @Provides
    @Singleton
    fun provideLocalDataSource() = LocalDataSource()

    @Provides
    @Singleton
    fun provideGetWeather() = GetWeather()

    @Provides
    @Singleton
    fun provideRepository() = WeatherRepository()

    @Provides
    @Singleton
    fun  provideWeatherService(retrofit: Retrofit): WeatherService =
        retrofit.create(WeatherService::class.java)


}