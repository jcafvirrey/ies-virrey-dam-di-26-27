package com.example.myfirstcomposeapp.components.b3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NameField(modifier: Modifier = Modifier){
    var name by rememberSaveable{mutableStateOf("") }
    TextField(
        value = name,
        onValueChange = {name = it},
        label = { Text("Name")},
        modifier = modifier.fillMaxWidth()
    )
}
@Composable
fun MyTextField(modifier: Modifier = Modifier){
    var name by rememberSaveable{ mutableStateOf("") }
    var surname by rememberSaveable{mutableStateOf("") }
    Column(){
        TextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("Name")},
            modifier = modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = surname,
            onValueChange = {surname = it},
            label = {Text("Surname")},
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White),

        )
    }

}
@Composable
fun MailAndPassword(modifier: Modifier = Modifier){
    var email by rememberSaveable {mutableStateOf("")}
    var password by rememberSaveable {mutableStateOf("") }
    var showPassword by rememberSaveable {mutableStateOf(false) }
    val emailError = email.isNotEmpty() && !email.contains("@")
    Column(){
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {Text("email")},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Password")},
            singleLine = true,
            visualTransformation = if(showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
            trailingIcon = {
                TextButton(onClick = {showPassword = !showPassword})  {
                    Text(if (showPassword) "Hide" else "Show")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Email")},
            isError = emailError,
            supportingText = {if (emailError) Text("Enter a valid email")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun MyPreviewMyTextField(){

    NameField()
    //MyTextField()
    //MailAndPassword()
}

