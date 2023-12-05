package com.example.harrypotterapp.data.utilities

import com.example.harrypotterapp.data.api.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingManager(val service : Service) {
    companion object{
        private var instance : NetworkingManager? = null
        private const val BASE_URL = "https://hp-api.onrender.com/api/"

        fun getInstance() : NetworkingManager{
            if(instance == null){
                val service = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(Service::class.java)
                instance = NetworkingManager(service)
            }
            return instance!!
        }
    }

}