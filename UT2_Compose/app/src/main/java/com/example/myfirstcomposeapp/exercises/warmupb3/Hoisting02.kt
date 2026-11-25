package com.example.myfirstcomposeapp.exercises.warmupb3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Hoisting02(modifier: Modifier = Modifier){
    var darkMode by rememberSaveable{ mutableStateOf(false)}
    Column(){
        DarkModeRow(darkMode,{darkMode = !darkMode})
        Text(if(darkMode) "Dark mode is ON" else "Dark mode is OFF")
    }

}

@Composable
fun DarkModeRow(checked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier = Modifier){
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)){
        Text("Dark Mode")
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreviewHoisting02(){
    //DarkModeRow(true,{})
    Hoisting02()
}
