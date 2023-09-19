package com.kawaki.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kawaki.weather.R

@Composable
fun WeatherCards(title: String, subtitle: String, icon: Int) {
    Surface(modifier = Modifier.size(150.dp)
        .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        color = Color(0xFF03A9F4)
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(painter = painterResource(id = icon), contentDescription = title, tint = Color.White, modifier = Modifier.size(25.dp))
            Text(text = title, style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White))
            Text(text = subtitle, style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Normal, color = Color.White))
        }
    }
}