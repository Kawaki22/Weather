package com.kawaki.weather.network

import com.kawaki.weather.Utils
import com.kawaki.weather.model.MWeather
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = Utils.API_KEY
        ): MWeather

//    @Headers("Authorization: Bearer ${Utils.API_KEY}", "Content-Type: ${Utils.CONTENT_TYPE}")
//    @GET("locations/v1/cities/search")
//    suspend fun getKey(
//    @Query("apikey") apikey: String = Utils.API_KEY,
//    @Query("q") query: String
//    ): List<MLocationKeyItem>

//    @GET("currentconditions/v1/{locationKey}")
//    suspend fun getWeather(
//        @Path("locationKey") locationKey: String,
//        @Query("apikey") apikey: String = Utils.API_KEY
//    ): MWeatherData

}