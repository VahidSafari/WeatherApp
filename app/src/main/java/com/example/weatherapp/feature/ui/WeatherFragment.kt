package com.example.weatherapp.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.feature.ui.WeatherView
import com.example.weatherapp.feature.ui.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_weather.*

class WeatherFragment : Fragment() {
    lateinit var binding: FragmentWeatherBinding

    private val weatherViewModel by lazy {
        ViewModelProviders.of(this).get(WeatherViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_search.setOnClickListener {
            val message = weatherViewModel.getWeatherStatus(
                et_city_name.text.toString())
            if (message.isEmpty()) {
                weatherViewModel.getWeatherStatusDB(et_city_name.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        if (it != null)
                            binding.weatherView = it.toWeatherStatus().toWeatherView()
                        else
                            binding.weatherView = WeatherView("API PROBLEM!",0.0)
                    })
            } else {
                binding.weatherView = WeatherView(message,0.0)
            }
        }
    }

}