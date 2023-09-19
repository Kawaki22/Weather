package com.kawaki.weather.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kawaki.weather.data.DataOrException
import com.kawaki.weather.model.MWeather
import com.kawaki.weather.repositories.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val homeScreenRepository: HomeScreenRepository): ViewModel() {

//    private val _locationKeyData: MutableState<DataOrException<List<MLocationKeyItem>, Boolean, Exception>> = mutableStateOf(DataOrException(listOf(), true, Exception("")))
//    val locationKeyData = _locationKeyData

    private val _weatherData: MutableState<DataOrException<MWeather, Boolean, Exception>> = mutableStateOf(DataOrException(null, true, Exception("")))
    val weatherData = _weatherData

    fun getWeather(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _weatherData.value = homeScreenRepository.getWeather(city = city)
            if (_weatherData.value.data != null) _weatherData.value.loading = false
            Log.d("kEYSS", "getLocationKey: ${_weatherData.value}")
        }
    }

//    fun getLocationKey(city: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            _locationKeyData.value = homeScreenRepository.getLocationKey(city = city)
//            if (!_locationKeyData.value.data.isNullOrEmpty()) _locationKeyData.value.loading = false
//            Log.d("kEYSS", "getLocationKey: ${_locationKeyData.value}")
//        }
//    }
//
//    fun getWeatherData(key: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            _weatherData.value = homeScreenRepository.getWeatherData(locationKey = key)
//            if (_weatherData.value.data != null) _weatherData.value.loading = false
//            Log.d("kEYSS", "getLocationKey: ${_weatherData.value}")
//        }
//    }
}