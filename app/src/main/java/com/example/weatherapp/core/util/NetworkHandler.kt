package com.example.weatherapp.core.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager

class NetworkHandler constructor(private val context: Context) {
    companion object {
        private lateinit var connectivityManager: ConnectivityManager
        fun init(context: Context) {
            connectivityManager =
                context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        }

        fun hasNetworkConnection(): Boolean {
            if(!::connectivityManager.isInitialized)
                return false
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }

}