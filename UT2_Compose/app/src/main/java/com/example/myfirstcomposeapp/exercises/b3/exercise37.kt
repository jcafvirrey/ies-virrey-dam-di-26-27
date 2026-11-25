package com.example.myfirstcomposeapp.exercises.b3

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Exercise37(modifier: Modifier = Modifier){
    var name by rememberSaveable{ mutableStateOf("") }
    var message by rememberSaveable{mutableStateOf("") }
    var sent by rememberSaveable{mutableStateOf(false) }
    FeedbackContent(name = name, message = message,sent = sent, onNameChange = {name = it}, onMessageChange = {message = it}, onSent = {sent = !sent})
}
@Composable
fun FeedbackContent(
    name: String,
    message: String,
    sent: Boolean,
    onNameChange: (String) -> Unit,
    onMessageChange: (String) -> Unit,
    onSent: () -> Unit,
    modifier: Modifier = Modifier){
    Column(modifier = Modifier.padding(8.dp)){
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            singleLine = true,
            label = {Text("Name")})
        OutlinedTextField(
            value = message,
            onValueChange = onMessageChange,
            label = {Text("Message")},
            maxLines = 4
        )
        Text("${message.length}/100", color = if(message.length>100) Color.Red else Color.Unspecified)
        Row(){
            Button(onClick = onSent, enabled = name.length!=0){
                Text("Send")
            }
            if(sent){
                Text("Thanks, ${name}")
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun MyPreviewExercise37(){
    Exercise37()
}
@Preview(showBackground = true)
@Composable
fun MyPreviewExercise73B(){
    //FeedbackContent("", "Este es mi primer mensaje",false,{},{},{})
}