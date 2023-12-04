package com.example.harrypotterapp.views.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.harrypotterapp.data.Wand
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.views.character.components.InfoCharacterCard
import com.example.harrypotterapp.views.character.components.InfoWandCard

@Composable
fun CharacterScreen(
    character : Character
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 15.dp)
                .background(backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            item{
                Text(
                    text = character.name!!,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Born: ${character.dateOfBirth!!} - ${character.gender!!.replaceFirstChar { it.uppercase() }}",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            item{

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = character.image,
                            contentDescription = "",
                            modifier = Modifier
                                .size(width = 200.dp, height = 250.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = character.house!!.replaceFirstChar { it.uppercase() },
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
            item{
                InfoCharacterCard(
                    character = character
                )
            }
            if(character.wand != null){
                item{
                    InfoWandCard(character = character)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCharacterView(

) {
    val character = Character(
        name = "Harry Potter",
        dateOfBirth = "31-07-1980",
        gender = "male",
        house = "gryffindor",
        species = "human",
        alive = true,
        patronus = "stag",
        image = "https://ik.imagekit.io/hpapi/harry.jpg",
        wand = Wand(wood = "holly", length = 11.0, core = "phoenix tail feather")
    )
    CharacterScreen(character = character)
}