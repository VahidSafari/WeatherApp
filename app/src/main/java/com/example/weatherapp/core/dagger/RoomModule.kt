package com.example.weatherapp.core.dagger

import android.content.Context
import androidx.room.Room
import com.example.weatherapp.core.db.WeatherDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    private val databaseName = "weather.db"

    @Provides
    @Singleton
    fun provideDB(context: Context) =
        Room.databaseBuilder(
        context,
        WeatherDatabase::class.java,
        databaseName
    ).build()



}