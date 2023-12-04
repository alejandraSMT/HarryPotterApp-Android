package com.example.harrypotterapp.views.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.R
import com.example.harrypotterapp.ui.theme.topBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarHPApp(
    screenName: String
) {
    TopAppBar(
        modifier = Modifier,
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.houses_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(width = 40.dp, height = 50.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = screenName,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(topBar)
    )
}

@Preview
@Composable
fun PreviewTopBar() {
    TopBarHPApp("Hogwarts")
}
