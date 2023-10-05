package com.kawaki.weather.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kawaki.weather.model.MCity
import com.kawaki.weather.model.MWeather

@Database(entities = [MCity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}