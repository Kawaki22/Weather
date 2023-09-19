package com.kawaki.weather.repositories

import com.kawaki.weather.data.DataOrException
import com.kawaki.weather.model.MWeather
import com.kawaki.weather.network.WeatherApi
import javax.inject.Inject

class HomeScreenRepository @Inject constructor(private val weatherApi: WeatherApi) {

    suspend fun getWeather(city: String): DataOrException<MWeather, Boolean, Exception> {
        val dataOrException = DataOrException<MWeather, Boolean, Exception>()

        try {
            dataOrException.data = weatherApi.getWeather(query = city)
        }catch (ex: Exception) {
            dataOrException.e = ex
        }
        return dataOrException
    }

//    suspend fun getLocationKey(city: String): DataOrException<List<MLocationKeyItem>, Boolean, Exception> {
//        val dataOrException = DataOrException<List<MLocationKeyItem>, Boolean, Exception>()
//
//        try {
//            dataOrException.data = weatherApi.getKey(query = city)
//        }catch (ex: Exception) {
//            dataOrException.e = ex
//        }
//        return dataOrException
//    }
//
//    suspend fun getWeatherData(locationKey: String): DataOrException<MWeatherData, Boolean, Exception> {
//        val dataOrException = DataOrException<MWeatherData, Boolean, Exception>()
//
//        try {
//            dataOrException.data = weatherApi.getWeather(locationKey = locationKey)
//        }catch (ex: Exception) {
//            dataOrException.e = ex
//        }
//        return dataOrException
//    }
}