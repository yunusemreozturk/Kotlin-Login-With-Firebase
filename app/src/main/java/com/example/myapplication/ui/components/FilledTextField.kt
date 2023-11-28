package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyFilledTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    validator: (String) -> String? = { null }
) {
    var validationText: String? by remember {
        mutableStateOf(null)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        value = value,
        onValueChange = {
            onValueChange(it)
            validationText = validator(it)
        },
        label = { Text(label) },
        maxLines = 1,
        isError = validationText != null
    )

    if (validationText != null) {
        Text(
            text = validationText ?: "",
            color = Color.Red,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}