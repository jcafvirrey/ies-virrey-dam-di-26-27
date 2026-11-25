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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Hoisting04(modifier: Modifier = Modifier){
    var apples by rememberSaveable{ mutableStateOf(0) }
    var bread by rememberSaveable{mutableStateOf(0) }
    var milk by rememberSaveable{mutableStateOf(0) }
    Column(){
        QuantityRow("Apples",apples,{apples--},{apples++})
        QuantityRow("Bread",bread,{bread--},{bread++})
        QuantityRow("Milk",milk, {milk--}, {milk++})
        Text(
            "Total items: ${apples + bread + milk}",
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp))

    }
}
@Composable
fun QuantityRow(
    name: String,
    quantity: Int,
    onDecrease: () ->Unit,
    onIncrease: () ->Unit, modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)){
        Text(name, modifier = Modifier.weight(1f))
        Text("$quantity")
        Button(onClick = onDecrease, enabled = (quantity>0)){
            Text("-")
        }
        Button(onClick = onIncrease, ){
            Text("+")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreviewHoisting04(){
    Hoisting04()
}