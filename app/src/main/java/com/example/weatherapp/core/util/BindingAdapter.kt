package com.example.weatherapp.core.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("DoubleToString")
fun toString(view:TextView, double: Double){
    view.text = double.toString()
}