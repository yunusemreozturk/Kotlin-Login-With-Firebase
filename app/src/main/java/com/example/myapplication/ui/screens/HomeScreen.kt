package com.example.myapplication.ui.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.components.HomePageCard

@Composable
fun HomeScreen(onCardClick: (Int) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(4) {
            HomePageCard(onCardClick, it)
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        HomeScreen(onCardClick = {})
    }
}