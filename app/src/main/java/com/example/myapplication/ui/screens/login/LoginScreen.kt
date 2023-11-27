package com.example.myapplication.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.components.MyFilledTextField
import com.example.myapplication.ui.components.MyFilledTonalButton

@Composable
fun LoginScreen(onPressedSignInButton: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box() {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        MyFilledTextField(initString = "Email Giriniz", label = "Email")
        Spacer(modifier = Modifier.height(10.dp))
        MyFilledTextField(initString = "Parola Giriniz", label = "Parola")
        Spacer(modifier = Modifier.height(30.dp))
        MyFilledTonalButton(onClick = onPressedSignInButton, text = "Giriş Yap")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    MyApplicationTheme {
        LoginScreen({})
    }
}