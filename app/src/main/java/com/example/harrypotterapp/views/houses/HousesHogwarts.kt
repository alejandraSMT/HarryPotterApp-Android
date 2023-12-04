package com.example.harrypotterapp.views.houses

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.House
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.ui.theme.gryffindorFirst
import com.example.harrypotterapp.ui.theme.gryffindorSecond
import com.example.harrypotterapp.ui.theme.hufflepuffFirst
import com.example.harrypotterapp.ui.theme.hufflepuffSecond
import com.example.harrypotterapp.ui.theme.ravenclawFirst
import com.example.harrypotterapp.ui.theme.ravenclawSecond
import com.example.harrypotterapp.ui.theme.slytherinFirst
import com.example.harrypotterapp.ui.theme.slytherinSecond
import com.example.harrypotterapp.views.common.TopBarHPApp
import com.example.harrypotterapp.views.houses.components.CardHouse

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HousesHogwarts(

) {
    val gryffindor = House(name = "Gryffindor", badge = R.drawable.gryffindor, firstColor = gryffindorFirst, secondColor = gryffindorSecond)
    val slytherin = House(name = "Slytherin", badge = R.drawable.slytherin, firstColor = slytherinFirst, secondColor = slytherinSecond)
    val hufflepuff = House(name = "Hufflepuff", badge = R.drawable.hufflepuf, firstColor = hufflepuffFirst, secondColor = hufflepuffSecond)
    val ravenclaw = House(name = "Ravenclaw", badge = R.drawable.ravenclaw, firstColor = ravenclawFirst, secondColor = ravenclawSecond)
    val houses = listOf(gryffindor,slytherin,hufflepuff,ravenclaw)
    
    val images = listOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4)

    val pagerState = rememberPagerState(pageCount = { images.size })

    Scaffold(
        topBar = {
            TopBarHPApp(
            screenName = "Hogwarts Houses"
            )
        }
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(0.9f)
                .background(backgroundColor)
                .padding(top = 75.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically,
                pageSpacing = 10.dp,
                modifier = Modifier.background(Color.Transparent)
            ) {
                page ->
                Column(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = images[page]),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(20.dp))
                            .size(width = 400.dp, height = 250.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(top=5.dp,bottom = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(7.dp)
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 200.dp),
                modifier = Modifier
                    .padding(top = 15.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(houses.size) {
                    CardHouse(
                        house = houses[it]
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    HousesHogwarts()
}