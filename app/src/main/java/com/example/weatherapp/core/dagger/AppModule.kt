package com.example.weatherapp.core.dagger

import com.example.weatherapp.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: MainActivity) {

    @Provides
    @Singleton
    fun provideApplication() = application
}
