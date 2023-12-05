package com.example.harrypotterapp.views.character.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.ui.theme.wandInfoColor

@Composable
fun InfoWandCard(
    character: Character
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight(),
        colors = CardDefaults.cardColors(
            containerColor = wandInfoColor
        )
    ){
        Column(
            modifier = Modifier
                .padding(15.dp),
        ) {
            Row(

            ){
                Text(
                    text= "Wand: ",
                    color = Color.White,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){

                val wood = if(character.wand!!.wood == "") "Not specified" else character.wand.wood!!.replaceFirstChar { it.uppercase() }
                val length = if(character.wand.length == null) "Not specified" else "${character.wand.length} inch(es)"
                val core = if(character.wand.core == "") "Not specified" else character.wand.core!!.replaceFirstChar { it.uppercase() }

                Column(

                ) {
                    Text(
                        text= "Wood: $wood",
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text="Length: $length",
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text= "Core: $core",
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wand),
                        contentDescription = "wand",
                        modifier = Modifier
                            .size(width = 50.dp, height = 120.dp)
                            .align(Alignment.End)
                    )
                }
            }
        }
    }
}