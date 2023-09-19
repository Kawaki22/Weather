package com.kawaki.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.kawaki.weather.navigation.WeatherAppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val view = LocalView.current
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.statusBarColor = Utils.customBlue.toArgb()
            window.navigationBarColor = Utils.customBlue.toArgb()
//            WeatherTheme {
                    WeatherApp()
//            }
        }
    }
}

@Composable
fun WeatherApp() {
    WeatherAppNavigation()
}