package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.core.dagger.AppModule
import com.example.weatherapp.core.dagger.DaggerWeatherComponent
import com.example.weatherapp.core.dagger.WeatherComponent
import com.example.weatherapp.core.dagger.WeatherModule
import com.example.weatherapp.core.util.NetworkHandler
import com.example.weatherapp.feature.WeatherFragment

class MainActivity : AppCompatActivity() {

    companion object {
        val dagger: WeatherComponent = DaggerWeatherComponent.builder()
            .weatherModule(WeatherModule())
            .appModule(AppModule(MainActivity()))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.cl_main,WeatherFragment()
        ).commit()
        dagger.inject(this)
        NetworkHandler.init(this)
    }
}