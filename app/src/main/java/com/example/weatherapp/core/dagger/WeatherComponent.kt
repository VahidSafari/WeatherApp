package com.example.weatherapp.core.dagger

import androidx.annotation.Nullable
import com.example.weatherapp.MainActivity
import com.example.weatherapp.feature.data.LocalDataSource
import com.example.weatherapp.feature.data.RemoteDataSource
import com.example.weatherapp.feature.data.WeatherRepository
import com.example.weatherapp.feature.domain.GetWeather
import com.example.weatherapp.feature.ui.WeatherViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        WeatherModule::class,
        RetrofitModule::class,
        AppModule::class,
        RoomModule::class
    ]
)
interface WeatherComponent {
    fun inject(target: WeatherRepository)
    fun inject(target: WeatherViewModel)
    fun inject(target: GetWeather)
    fun inject(target: RemoteDataSource)
    fun inject(target: LocalDataSource)
    fun inject(target: MainActivity)
}