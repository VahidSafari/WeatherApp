package com.example.weatherapp.feature.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherStatus(weatherStatusEntity: WeatherStatusEntity)

    @Transaction
    @Query("SELECT * FROM WeatherStatusEntity WHERE cityName=:cityName LIMIT 1")
    fun getWeatherStatus(cityName: String): LiveData<WeatherStatusEntity>
}