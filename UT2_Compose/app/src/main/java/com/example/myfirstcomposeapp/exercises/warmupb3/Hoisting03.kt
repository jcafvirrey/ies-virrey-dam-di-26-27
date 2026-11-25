package com.example.myfirstcomposeapp.exercises.warmupb3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun Hoisting03(modifier: Modifier = Modifier){
    var temperature by rememberSaveable {mutableStateOf(12) }
    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.Center){
        TemperatureDisplay(temperature)
        TemperatureControls({temperature--},{temperature++})
    }
}
@Composable

fun TemperatureDisplay(temperature: Int, modifier: Modifier = Modifier) {
    Text(
        "$temperature ºC",
        fontSize = 40.sp,
        color = when {
            temperature < 18 -> Color(0xFF1565C0)
            temperature >= 24 -> Color.Red
            else -> Color.Unspecified
        },
        modifier = modifier
    )
}
@Composable
fun TemperatureControls(onDecrease: ()->Unit,onIncrease: ()->Unit, modifier: Modifier = Modifier){
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)){
        Button(onClick = onDecrease){
            Text("-")
        }
        Button(onClick = onIncrease){
            Text("+")
        }
    }
}

@Preview
@Composable
fun MyPreviewHoisting03(){
    Hoisting03()
}