package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.core.dagger.*
import com.example.weatherapp.core.util.NetworkHandler
import com.example.weatherapp.feature.WeatherFragment

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var dagger: WeatherComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(
            R.id.cl_main,WeatherFragment()
        ).commit()
        dagger= DaggerWeatherComponent.builder()
            .appModule(AppModule(this))
            .build()
        dagger.inject(this)
        NetworkHandler.init(this)
    }
}
