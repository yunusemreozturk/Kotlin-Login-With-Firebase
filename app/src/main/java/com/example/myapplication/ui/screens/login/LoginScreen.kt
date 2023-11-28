package com.example.myapplication.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.components.MyFilledTextField
import com.example.myapplication.ui.components.MyFilledTonalButton
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodels.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.util.Validators


@Composable
fun LoginScreen(onPressedSignInButton: () -> Unit, viewModel: AuthViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    val emailValidator = Validators.isValidEmail(uiState.emailField)
    val passwordValidator = Validators.isValidPassword(uiState.passwordField)

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
        MyFilledTextField(
            value = uiState.emailField,
            onValueChange = { uiState.emailField = it },
            validator = { emailValidator },
            label = "Email"
        )
        Spacer(modifier = Modifier.height(10.dp))
        MyFilledTextField(
            value = uiState.passwordField,
            onValueChange = { uiState.passwordField = it },
            validator = { passwordValidator },
            label = "Parola"
        )
        Spacer(modifier = Modifier.height(30.dp))
        MyFilledTonalButton(onClick = {
            if (emailValidator == null && passwordValidator == null) {
                onPressedSignInButton()
            }
        }, text = "Giriş Yap")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    MyApplicationTheme {
        LoginScreen({})
    }
}