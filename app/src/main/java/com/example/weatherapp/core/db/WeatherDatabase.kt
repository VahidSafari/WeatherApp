package com.example.weatherapp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.feature.data.WeatherDao
import com.example.weatherapp.feature.data.WeatherStatusEntity

@Database(entities = [WeatherStatusEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao

//    companion object {
//        private var db: WeatherDatabase? = null
//        private const val databaseName = "weather.db"
//
//        fun init(context: Context) {
//            if (db == null) {
//                db = Room.databaseBuilder(context, WeatherDatabase::class.java, databaseName)
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//        }
//
//        fun getInstance(): WeatherDatabase? {
//            return db
//        }
//    }
}