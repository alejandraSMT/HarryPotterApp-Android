package com.example.harrypotterapp.views.byHouses

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.harrypotterapp.R
import com.example.harrypotterapp.views.byHouses.viewmodel.ByHouseViewModel
import com.example.harrypotterapp.views.common.LoadingProgress
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun CharactersInHouseScreen(
    houseName: String,
    houseDarker: String,
    byHouseViewModel: ByHouseViewModel,
    navController: NavController
) {
    val coroutine= rememberCoroutineScope()

    LaunchedEffect(key1 = true){
        coroutine.launch {
            byHouseViewModel.getCharactersByHouse(houseName)
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier,
                title = {
                    Text(
                        text = houseName.replaceFirstChar { it.uppercase()},
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(houseDarker.toColorInt())
                )
            )
        }
    ) {padding ->

        BackHandler(
            onBack = {
                navController.popBackStack()
            },
            enabled = true
        )

        val boys = byHouseViewModel.charactersList.filter { it.gender == "male" && it.hogwartsStudent == true}
        val girls = byHouseViewModel.charactersList.filter { it.gender == "female" && it.hogwartsStudent == true }

        if(!byHouseViewModel.loaded.value){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LoadingProgress()
            }
        }else{
            LazyColumn(
                modifier = Modifier
                    .padding(top = 80.dp)
                    .padding(horizontal = 15.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                item {
                    Text(
                        text = "Girls Dorm",
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                    LazyRow(
                        state = rememberLazyListState()
                    ) {
                        items(girls) { girl ->
                            Column(
                                modifier = Modifier
                                    .padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.6f)
                                        .padding(vertical = 5.dp)
                                        .clickable {
                                            navController.navigate("charInfo/${girl.id}")
                                        }
                                ) {
                                    if (girl.image == "") {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentSize(Alignment.Center),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(width = 200.dp, height = 240.dp)
                                                    .background(Color.Black),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.houses_icon),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .size(width = 80.dp, height = 100.dp)
                                                )
                                            }
                                        }
                                    } else {
                                        AsyncImage(
                                            model = girl.image,
                                            contentDescription = "",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(width = 200.dp, height = 240.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = girl.name!!,
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
                item {
                    Text(
                        text = "Boys Dorm",
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 10.dp)
                    )
                    LazyRow(

                    ) {
                        items(boys) { boy ->
                            Column(
                                modifier = Modifier
                                    .padding(10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.6f)
                                        .padding(vertical = 5.dp)
                                        .clickable {
                                            navController.navigate("charInfo/${boy.id}")
                                        }
                                ) {
                                    if (boy.image == "") {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .wrapContentSize(Alignment.Center),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(width = 200.dp, height = 240.dp)
                                                    .background(Color.Black),
                                                contentAlignment = Alignment.Center
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.houses_icon),
                                                    contentDescription = "",
                                                    modifier = Modifier
                                                        .size(width = 80.dp, height = 100.dp)
                                                )
                                            }
                                        }
                                    } else {
                                        AsyncImage(
                                            model = boy.image,
                                            contentDescription = "",
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier
                                                .size(width = 200.dp, height = 240.dp)
                                        )
                                    }
                                }
                                Text(
                                    text = boy.name!!,
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}