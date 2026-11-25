package com.example.myfirstcomposeapp.exercises.warmupb3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Hoisting05(modifier: Modifier = Modifier) {
    var name by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        NameField(name, onNameChange = { name = it })
        Text("Hello, $name!")
        TextButton(onClick = { name = "" }) { Text("Clear") }
    }
}

@Composable
fun NameField(name: String, onNameChange: (String) -> Unit) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Name") }
    )
}
@Preview(showBackground = true)
@Composable
fun MyPreviewHoisting05(){
    //Hoisting05()
    NameField("Ana"){}
}
