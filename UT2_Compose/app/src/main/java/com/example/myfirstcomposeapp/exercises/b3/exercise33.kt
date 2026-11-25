package com.example.myfirstcomposeapp.exercises.b3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Exercise33(modifier: Modifier = Modifier){
    var count by rememberSaveable{mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxWidth(),
        Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("${count}", fontSize = 32.sp)
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()){
            Button(onClick = {count--}, enabled = count!=0){
                Text("-1")
            }
            Button(onClick = {count++}){
                Text("+1")
            }
            Button(onClick = {count = 0}, enabled = count!=0 ) {
                Text("Reset")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreviewExercise33(){
    Exercise33()
}