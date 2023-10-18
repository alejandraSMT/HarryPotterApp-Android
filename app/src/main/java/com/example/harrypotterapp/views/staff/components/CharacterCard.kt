package com.example.harrypotterapp.views.staff.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.ui.theme.cardGeneral

@Composable
fun CharacterCard(
    staff : Character
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(vertical = 12.dp)
            .clickable {
                       
            },
        colors = CardDefaults.cardColors(
            containerColor = cardGeneral,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = staff.image!!,
                    contentDescription = "character image",
                    modifier = Modifier
                        .size(width = 60.dp, height = 50.dp)
                        .padding(horizontal = 7.dp)
                        .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        color = Color.Black,
                        text = staff.name!!,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        color = Color.Gray  ,
                        text = "Species: ${staff.species} - House: ${staff.house}",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = "arrow",
                    modifier = Modifier
                        .size(width = 20.dp, height = 40.dp),
                    colorFilter = ColorFilter.tint(color = Color.Gray)
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewCharacterCard() {
    val staff1 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    CharacterCard(staff1)
}