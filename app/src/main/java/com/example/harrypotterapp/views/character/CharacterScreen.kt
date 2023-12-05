package com.example.harrypotterapp.views.character

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.Wand
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.views.character.components.InfoCharacterCard
import com.example.harrypotterapp.views.character.components.InfoWandCard
import com.example.harrypotterapp.views.character.viewmodel.CharacterInfoViewModel
import com.example.harrypotterapp.views.common.LoadingProgress
import kotlinx.coroutines.launch

@Composable
fun CharacterScreen(
    idCharacter : String,
    characterInfoViewModel: CharacterInfoViewModel
    //character : Character
) {
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = true){
        coroutine.launch {
            characterInfoViewModel.getCharacterInfo(idCharacter)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(!characterInfoViewModel.loaded.value){
            LoadingProgress()
        }else{
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
                        text = characterInfoViewModel.characterInfo.value.name!!,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    val date = if(characterInfoViewModel.characterInfo.value.dateOfBirth == null) "Not specified" else characterInfoViewModel.characterInfo.value.dateOfBirth!!
                    Text(
                        text = "Born: $date - ${characterInfoViewModel.characterInfo.value.gender!!.replaceFirstChar { it.uppercase() }}",
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
                            if(characterInfoViewModel.characterInfo.value.image == ""){
                                Box(
                                    modifier = Modifier
                                        .size(width = 200.dp, height = 250.dp)
                                        .background(Color.Black),
                                    contentAlignment = Alignment.Center
                                ){
                                    Image(
                                        painter = painterResource(id = R.drawable.houses_icon),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .size(width = 80.dp, height = 100.dp)
                                    )
                                }
                            }else{
                                AsyncImage(
                                    model = characterInfoViewModel.characterInfo.value.image,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(width = 200.dp, height = 250.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            val house = if(characterInfoViewModel.characterInfo.value.house == "") "Not specified" else characterInfoViewModel.characterInfo.value.house!!
                            Text(
                                text = house.replaceFirstChar { it.uppercase() },
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
                        character = characterInfoViewModel.characterInfo.value
                    )
                }
                val character = characterInfoViewModel.characterInfo.value.wand!!
                if(character.core != "" || character.wood != "" || character.length != null){
                    item{
                        InfoWandCard(
                            character = characterInfoViewModel.characterInfo.value
                        )
                    }
                }
            }
        }
    }
}