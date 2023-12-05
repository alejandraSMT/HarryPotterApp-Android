package com.example.harrypotterapp.views.houses.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.House
import com.example.harrypotterapp.ui.theme.gryffindorDarker
import com.example.harrypotterapp.ui.theme.gryffindorFirst
import com.example.harrypotterapp.ui.theme.gryffindorSecond
import com.example.harrypotterapp.views.houses.HousesHogwarts

@Composable
fun CardHouse(
    house: House,
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                navController.navigate("byHouse/${house.name}/${house.darkerColor}")
            }
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .background(Color.Transparent),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.7f)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    house.firstColor,
                                    house.secondColor
                                )
                            )
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .padding(5.dp)
                            .size(120.dp, 120.dp),
                        painter = painterResource(id =  house.badge),
                        contentDescription = "badge of house"
                    )
                }
            }
        }

        Text(
            text = house.name,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}