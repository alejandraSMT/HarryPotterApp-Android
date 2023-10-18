package com.example.harrypotterapp.views.houses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.House
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.ui.theme.gryffindorFirst
import com.example.harrypotterapp.ui.theme.gryffindorSecond
import com.example.harrypotterapp.ui.theme.hufflepuffFirst
import com.example.harrypotterapp.ui.theme.hufflepuffSecond
import com.example.harrypotterapp.ui.theme.ravenclawFirst
import com.example.harrypotterapp.ui.theme.ravenclawSecond
import com.example.harrypotterapp.ui.theme.slytherinFirst
import com.example.harrypotterapp.ui.theme.slytherinSecond
import com.example.harrypotterapp.views.houses.components.CardHouse

@Composable
fun HousesHogwarts(

) {
    val gryffindor = House(name = "Gryffindor", badge = R.drawable.gryffindor, firstColor = gryffindorFirst, secondColor = gryffindorSecond)
    val slytherin = House(name = "Slytherin", badge = R.drawable.slytherin, firstColor = slytherinFirst, secondColor = slytherinSecond)
    val hufflepuff = House(name = "Hufflepuff", badge = R.drawable.hufflepuf, firstColor = hufflepuffFirst, secondColor = hufflepuffSecond)
    val ravenclaw = House(name = "Ravenclaw", badge = R.drawable.ravenclaw, firstColor = ravenclawFirst, secondColor = ravenclawSecond)
    val houses = listOf(gryffindor,slytherin,hufflepuff,ravenclaw)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top=10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hogwarts Houses",
            color = Color.White,
            style = MaterialTheme.typography.headlineLarge
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                houses.forEach { house ->
                    CardHouse(
                        house = house
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    HousesHogwarts()
}