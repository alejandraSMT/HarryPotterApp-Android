package com.example.harrypotterapp.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.harrypotterapp.views.houses.HousesHogwarts
import com.example.harrypotterapp.views.spells.SpellsScreen
import com.example.harrypotterapp.views.staff.StaffHogwarts


@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "houses"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable("houses"){
            HousesHogwarts()
        }

        composable("staff"){
            StaffHogwarts()
        }

        composable("spells"){
            SpellsScreen()
        }
    }
}