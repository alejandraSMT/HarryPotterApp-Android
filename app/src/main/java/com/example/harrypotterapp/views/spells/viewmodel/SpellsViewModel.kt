package com.example.harrypotterapp.views.spells.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterapp.data.model.Spell
import com.example.harrypotterapp.data.utilities.NetworkingManager
import kotlinx.coroutines.launch

class SpellsViewModel : ViewModel(

) {
    val spellsList = mutableStateListOf<Spell>()
    val loaded = mutableStateOf(false)

    fun getSpellsList(){
        try{
            loaded.value = false
            viewModelScope.launch {
                val networkingManager = NetworkingManager.getInstance()
                val response = networkingManager.service.getSpells()
                val list = response.body()!!

                list.forEach { spell ->
                    spellsList.add(spell)
                }
                loaded.value = true
            }
        }catch(e: Exception){
            loaded.value = true
            Log.e("ERROR GET_SPELLS",e.message.toString())
        }
    }
}