package com.example.harrypotterapp.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.harrypotterapp.views.byHouses.viewmodel.ByHouseViewModel
import com.example.harrypotterapp.views.byHouses.CharactersInHouseScreen
import com.example.harrypotterapp.views.character.CharacterScreen
import com.example.harrypotterapp.views.character.viewmodel.CharacterInfoViewModel
import com.example.harrypotterapp.views.houses.HousesHogwarts
import com.example.harrypotterapp.views.spells.SpellsScreen
import com.example.harrypotterapp.views.spells.viewmodel.SpellsViewModel
import com.example.harrypotterapp.views.staff.StaffHogwarts
import com.example.harrypotterapp.views.staff.viewmodel.StaffViewModel


@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "houses",
    byHouseViewModel: ByHouseViewModel = hiltViewModel(),
    staffViewModel: StaffViewModel = hiltViewModel(),
    characterInfoViewModel: CharacterInfoViewModel = hiltViewModel(),
    spellsViewModel: SpellsViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable("houses"){
            HousesHogwarts(
                navController = navController
            )
        }

        composable("staff"){
            StaffHogwarts(
                staffViewModel = staffViewModel,
                navController = navController
            )
        }

        composable("spells",){
            SpellsScreen(
                spellsViewModel = spellsViewModel
            )
        }

        composable("byHouse/{houseName}/{houseDarker}",
            arguments = listOf(
                navArgument("houseName"){
                    type = NavType.StringType
                },
                navArgument("houseDarker"){
                    type = NavType.StringType
                }
            )
        ){
            val houseName = it.arguments!!.getString("houseName")
            val houseDarker = it.arguments!!.getString("houseDarker")
            CharactersInHouseScreen(
                houseName = houseName!!,
                houseDarker = houseDarker!!,
                byHouseViewModel = byHouseViewModel,
                navController = navController
            )
        }

        composable("charInfo/{idCharacter}",
            arguments = listOf(
                navArgument("idCharacter"){
                    type = NavType.StringType
                }
            )
        ){
            val idCharacter = it.arguments!!.getString("idCharacter")
            CharacterScreen(
                idCharacter = idCharacter!!,
                characterInfoViewModel = characterInfoViewModel
            )
        }
    }
}