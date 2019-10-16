package com.example.weatherapp.core.api

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        private var retrofit: Retrofit? = null


        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request: Request = chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", "appid b6907d289e10d714a6e88b30761fae22")
                    .build()
                chain.proceed(request)
            }
            .build()

        fun getRetrofit(): Retrofit? {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://samples.openweathermap.org/data/2.5")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}