package com.example.harrypotterapp.views.staff

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.ui.theme.backgroundColor
import com.example.harrypotterapp.views.common.LoadingProgress
import com.example.harrypotterapp.views.common.TopBarHPApp
import com.example.harrypotterapp.views.staff.components.CharacterCard
import com.example.harrypotterapp.views.staff.viewmodel.StaffViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StaffHogwarts(
    staffViewModel: StaffViewModel,
    navController: NavController
) {

    val coroutine = rememberCoroutineScope()

    LaunchedEffect(key1 = true){
        coroutine.launch {
            staffViewModel.getStaff()
        }
    }

    Scaffold(
        topBar = { TopBarHPApp(screenName = "Hogwarts Staff")}
    ) {padding ->
        if(!staffViewModel.loaded.value){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LoadingProgress()
            }
        }else {
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
                ) {
                    item {
                        staffViewModel.staffList.forEach { staff ->
                            CharacterCard(
                                staff = staff,
                                navController = navController
                            )
                        }
                    }
                }

            }
        }
    }

}