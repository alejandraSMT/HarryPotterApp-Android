package com.example.harrypotterapp.views.character.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.ui.theme.infoColor

@Composable
fun InfoCharacterCard(
    character : Character
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight(),
        colors = CardDefaults.cardColors(
            containerColor = infoColor
        )
    ){
        Column(
            modifier = Modifier
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text= "Species: ",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text=if(character.species.equals("")) "Not specified" else character.species!!.replaceFirstChar { it.uppercase() },
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text= "Status: ",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text=if(character.alive!!) "Alive" else "Dead",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text= "Patronus: ",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text=if(character.patronus.equals("")) "Not specified" else character.patronus!!.replaceFirstChar { it.uppercase() },
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }

}