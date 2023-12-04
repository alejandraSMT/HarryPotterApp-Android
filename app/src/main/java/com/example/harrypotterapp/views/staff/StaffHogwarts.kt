package com.example.harrypotterapp.views.staff

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
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.views.common.TopBarHPApp
import com.example.harrypotterapp.views.staff.components.CharacterCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffHogwarts(

) {
    val staff1 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff2 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff3 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff4 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff5 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff6 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff7 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff8 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff9 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff10 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff11 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")
    val staff12 = Character(name = "Minerva McGonagall", species = "human", image = "https://ik.imagekit.io/hpapi/mcgonagall.jpg", house = "Gryffindor")

    val staffList = listOf(staff1,staff2,staff3,staff4,staff5,staff6,staff7,staff8,staff9,staff10,staff11,staff12)

    Scaffold(
        topBar = { TopBarHPApp(screenName = "Hogwarts Staff")}
    ) {padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(top = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(Color.Transparent)
                    .padding(top = 10.dp),
                contentPadding = PaddingValues(bottom = 30.dp)
            ){
                item {
                    staffList.forEach { staff ->
                        CharacterCard(
                            staff = staff
                        )
                    }
                }
            }

        }
    }

}

@Preview
@Composable
fun PreviewStaff() {
    StaffHogwarts()
}