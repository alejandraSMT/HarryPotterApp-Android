package com.example.harrypotterapp.views.staff.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.utilities.NetworkingManager
import kotlinx.coroutines.launch
import java.lang.Exception

class StaffViewModel : ViewModel(

) {
    val staffList = mutableStateListOf<Character>()
    val loaded = mutableStateOf(false)

    fun getStaff(){
        try{
            loaded.value = false
            staffList.clear()
            viewModelScope.launch {
                val networkingManager = NetworkingManager.getInstance()
                val response = networkingManager.service.getStaff()
                val list = response.body()!!

                list.forEach { staff ->
                    staffList.add(staff)
                }

                loaded.value = true
            }
        }catch(e: Exception){
            Log.e("ERROR GET_STAFF",e.message.toString())
            loaded.value = true
        }
    }

}