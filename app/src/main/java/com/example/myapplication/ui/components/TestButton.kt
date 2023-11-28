package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TestButton(onPressed: ()-> Unit) {
    Box(modifier = Modifier
        .background(Color.Red)
        .width(50.dp)
        .height(50.dp)
        .clickable {
            onPressed()
        })
}