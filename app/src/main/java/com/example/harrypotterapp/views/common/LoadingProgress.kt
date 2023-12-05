package com.example.harrypotterapp.views.common

import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingProgress() {
    CircularProgressIndicator(
        modifier = Modifier.width(35.dp),
        color = Color.White,
        trackColor = Color.Gray,
    )
}