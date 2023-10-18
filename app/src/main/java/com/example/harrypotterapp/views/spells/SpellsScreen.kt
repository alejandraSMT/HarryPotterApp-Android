package com.example.harrypotterapp.views.spells

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.data.model.Spell
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.views.common.TopBarHPApp
import com.example.harrypotterapp.views.spells.components.SpellCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpellsScreen(

) {

    val spell1 = Spell(name = "Aberto", description = "Opens locked doors")
    val spell2 = Spell(name = "Apparate", description = "A non-verbal transportation spell that allows a witch or wizard to instantly travel on the spot and appear at another location (disapparate is the opposite)")
    val spells = listOf(spell1,spell2)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Spells",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            contentPadding = PaddingValues(bottom = 30.dp)
        ){
            item{
                spells.forEach { spell ->
                    SpellCard(
                        spell = spell
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SpellsPreview() {
    SpellsScreen()
}