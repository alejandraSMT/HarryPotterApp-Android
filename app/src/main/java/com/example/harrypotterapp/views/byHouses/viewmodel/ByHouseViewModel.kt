package com.example.harrypotterapp.views.byHouses.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.utilities.NetworkingManager
import kotlinx.coroutines.launch

class ByHouseViewModel: ViewModel(

) {
    val charactersList = mutableStateListOf<Character>()
    val loaded = mutableStateOf(false)

    val networkingManager = NetworkingManager.getInstance()

    fun getCharactersByHouse(houseName: String){
        try {
            loaded.value = false
            viewModelScope.launch {
                charactersList.clear()
                val response = networkingManager.service.getCharactersByHouse(houseName)
                val listResponse = response.body()!!

                listResponse.forEach(){ character ->
                    charactersList.add(character)
                }
                loaded.value = true
            }

        }catch(e: Exception){
            loaded.value = true
            Log.e("ERROR CHARACTERS_BY_HOUSE",e.message.toString())
        }

    }

}