package com.example.myfirstcomposeapp.exercises.warmupb3

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Hoisting01(modifier: Modifier = Modifier){
    var likes by rememberSaveable{ mutableStateOf(0) }
    LikeButton(likes,{likes++})

}
@Composable
fun LikeButton(likes: Int, onLike:()->Unit, modifier: Modifier = Modifier){

    Button(onClick = onLike) {
        Text("Likes: $likes")
    }
}

@Preview
@Composable
fun MyPreviewHoisting01(){
    Hoisting01()
    //LikeButton(25,{})
}
@Preview
@Composable
fun MyPreview2Hoisting01(){
    //Hoisting01()
    LikeButton(likes=25, {})
}