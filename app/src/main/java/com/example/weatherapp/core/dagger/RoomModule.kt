package com.example.weatherapp.core.dagger

import android.app.Activity
import androidx.room.Room
import com.example.weatherapp.core.db.WeatherDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(activity: Activity) {

    private val databaseName = "weather.db"
    private var database: WeatherDatabase

    init {
        database =
            Room.databaseBuilder(
            activity,
            WeatherDatabase::class.java,
            databaseName
        ).build()
    }

    @Provides
    @Singleton
    fun provideDB() = database



}