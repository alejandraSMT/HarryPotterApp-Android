package com.example.harrypotterapp.views.spells

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    val searchText = remember{ mutableStateOf("") }
    val active = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopBarHPApp(screenName = "Spells")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(top = 75.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 5.dp),
                value = searchText.value,
                onValueChange = {searchText.value = it},
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector =  Icons.Rounded.Search,
                            contentDescription = "",
                            tint = Color.Gray
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { searchText.value = "" }) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "",
                            tint = Color.LightGray
                        )
                    }
                },
                placeholder = { Text(text = "Search a spell...")},
                shape = RoundedCornerShape(20.dp),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(0.9f),
                contentPadding = PaddingValues(bottom = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val filteredSpells =
                    spells.filter { it.name!!.contains(searchText.value, true) }
                item {
                    filteredSpells.forEach { spell ->
                        SpellCard(
                            spell = spell
                        )
                    }
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