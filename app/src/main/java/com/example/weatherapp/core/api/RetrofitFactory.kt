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
                    .build()
                chain.proceed(request)
            }
            .build()

        fun getRetrofit(): Retrofit? {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }
}