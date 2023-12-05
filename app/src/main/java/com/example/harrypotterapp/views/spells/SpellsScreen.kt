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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.data.model.Spell
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.views.common.LoadingProgress
import com.example.harrypotterapp.views.common.TopBarHPApp
import com.example.harrypotterapp.views.spells.components.SpellCard
import com.example.harrypotterapp.views.spells.viewmodel.SpellsViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpellsScreen(
    spellsViewModel: SpellsViewModel
) {

    val coroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = true){
        coroutine.launch {
            spellsViewModel.getSpellsList()
        }
    }

    val searchText = remember{ mutableStateOf("") }

    Scaffold(
        topBar = {
            TopBarHPApp(screenName = "Spells")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(top = 75.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(!spellsViewModel.loaded.value){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoadingProgress()
                }
            }else{
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(bottom = 5.dp),
                    value = searchText.value,
                    onValueChange = { searchText.value = it },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "",
                            tint = Color.Gray
                        )
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
                    placeholder = { Text(text = "Search a spell...") },
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
                        spellsViewModel.spellsList.filter { it.name!!.contains(searchText.value, true) }
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
}