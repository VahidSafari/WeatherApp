package com.example.weatherapp.feature.data

data class WeatherStatusResponse (

	val coord : Coord,
	val weather : List<Weather>,
	val base : String,
	val main : Main,
	val visibility : Int,
	val wind : Wind,
	val clouds : Clouds,
	val dt : Int,
	val sys : Sys,
	val id : Int,
	val name : String,
	val cod : Int
){
	fun toWeatherStatusEntity() =
		WeatherStatusEntity(id,weather[0].description,main.temp,name)
}