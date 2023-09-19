package com.kawaki.weather.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.kawaki.weather.screens.home.HomeScreenViewModel

/*
@Composable
fun SearchSuggestionCard(locationDataList: List<Mwea>, navHostController: NavHostController, viewModel: HomeScreenViewModel) {
    LazyColumn {
        items(items = locationDataList) { mLocation ->
            SearchSuggestionCardItem(locationData = mLocation, navHostController = navHostController, viewModel = viewModel)
        }
    }
}
@Composable
fun SearchSuggestionCardItem(locationData: MLocationKeyItem, navHostController: NavHostController, viewModel: HomeScreenViewModel) {

    val context = LocalContext.current

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
        .clickable {
            viewModel.getWeatherData(locationData.Key)
            Toast
                .makeText(context, "Please wait", Toast.LENGTH_LONG)
                .show()
//            navHostController.navigate(NavScreens.HomeScreen.route)
        },
        shape = RoundedCornerShape(18.dp),
        color = Color.Blue.copy(alpha = 0.2f)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start) {
            Text(text = "${locationData.LocalizedName}, ${locationData.AdministrativeArea.EnglishName}", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White))
            Text(text = locationData.Country.EnglishName, style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White.copy(alpha = 0.5f)))
        }
    }
}

 */