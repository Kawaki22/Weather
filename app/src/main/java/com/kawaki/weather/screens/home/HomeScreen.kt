package com.kawaki.weather.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kawaki.weather.Utils
import com.kawaki.weather.components.BottomBar
import com.kawaki.weather.R
import com.kawaki.weather.components.WeatherCards
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: HomeScreenViewModel = hiltViewModel()) {

    val weatherData = viewModel.weatherData.value.data
    val searchState = remember { mutableStateOf("") }
    val localKeyboard = LocalSoftwareKeyboardController.current
    val dateTime = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH)
    val simpleDateTime = dateTime.format(Date()).toString()

    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomBar(navHostController = navHostController) },
        topBar = {  },
        containerColor = Utils.customBlue) { innerPadding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextField(value = searchState.value, onValueChange = { searchState.value = it },
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults
                        .textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            containerColor = Color.Blue.copy(alpha = 0.2f),
                            textColor = Color.White),
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences, imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = { if (searchState.value.isNotBlank()) {
                        viewModel.getWeather(city = searchState.value)
                        localKeyboard?.hide()
                    } }),
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                    textStyle = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold)
                )

                if (weatherData != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {



                    Text(text = buildString {
                        Row {
                            Icon(
                                painter = painterResource(id = R.drawable.loation_weather),
                                contentDescription = "Location",
                                tint = Color(0xFF03A9F4)
                            )
                            Text(
                                text = " ${weatherData.name}, ",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            )
                            Text(
                                text = weatherData.sys.country,
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                )
                            )
                        }
                    })

                    Text(
                        text = simpleDateTime,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                    val weatherIcon = when(weatherData.weather.first().icon) {
                        "01d", "01n" -> R.drawable.clear_sky
                        "02d", "02n" -> R.drawable.few_clouds
                        "03d", "03n" -> R.drawable.scattered_broken_clouds
                        "04d", "04n" -> R.drawable.scattered_broken_clouds
                        "09d", "09n" -> R.drawable.rain
                        "10d", "10n" -> R.drawable.rain
                        "11d", "11n" -> R.drawable.thunderstorm
                        "13d", "13n" -> R.drawable.snow
                        "50d", "50n" -> R.drawable.mist
                        else -> R.drawable.clear_sky
                    }
                Image(
                    painter = painterResource(id = weatherIcon),
                    contentDescription = weatherData.weather.first().description,
                    modifier = Modifier
                        .size(250.dp)
                        .padding(top = 50.dp, bottom = 10.dp)
                )

                Text(
                    text = "${weatherData.main.temp}°c",
                    style = TextStyle(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = weatherData.weather.first().description,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                LazyHorizontalGrid(rows = GridCells.Fixed(2)) {

                    item {
                        WeatherCards(
                            title = "Wind",
                            subtitle = "${weatherData.wind.speed} Km/h",
                            icon = R.drawable.wind
                        )
                    }
                    item {
                        WeatherCards(
                            title = "Wind Gust",
                            subtitle = "${weatherData.wind.gust} Km/h",
                            icon = R.drawable.wind_gust
                        )
                    }
                    item {
                        WeatherCards(
                            title = "Humidity",
                            subtitle = "${weatherData.main.humidity}%",
                            icon = R.drawable.humidity
                        )
                    }
                    item {
                        WeatherCards(
                            title = "Pressure",
                            subtitle = "${weatherData.main.pressure} mb",
                            icon = R.drawable.air_pressure
                        )
                    }
                    item {
                        WeatherCards(
                            title = "visibility",
                            subtitle = "${weatherData.visibility} Km",
                            icon = R.drawable.visibility
                        )
                    }
                }
                }
            }
    }
}

@Preview
@Composable
fun Prev() {
    HomeScreen(navHostController = rememberNavController())
}