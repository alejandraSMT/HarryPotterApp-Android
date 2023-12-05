package com.example.harrypotterapp.views.character.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.utilities.NetworkingManager
import kotlinx.coroutines.launch
import java.lang.Exception

class CharacterInfoViewModel : ViewModel(

) {
    val characterInfo = mutableStateOf(Character())
    val loaded = mutableStateOf(false)

    fun getCharacterInfo(idCharacter: String){
        try{
            loaded.value = false
            viewModelScope.launch {
                val networkingManager = NetworkingManager.getInstance()
                val response = networkingManager.service.getCharacterInfo(idCharacter)
                val character = response.body()!!

                characterInfo.value = character[0]
                loaded.value = true
            }
        }catch (e: Exception){
            loaded.value = true
            Log.e("ERROR GET_CHARACTER_INFO", e.message.toString())
        }
    }

}