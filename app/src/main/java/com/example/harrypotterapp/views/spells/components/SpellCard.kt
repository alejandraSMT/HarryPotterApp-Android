package com.example.harrypotterapp.views.spells.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.data.model.Spell
import com.example.harrypotterapp.ui.theme.listItemColor

@Composable
fun SpellCard(
    spell: Spell
) {
    Card (
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = listItemColor)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = spell.name!!,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black
            )
            Text(
                text = spell.description!!,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun PreviewSpellsCard() {
    val spell = Spell(name = "Aberto", description = "Opens locked doors")
    SpellCard(spell)
}