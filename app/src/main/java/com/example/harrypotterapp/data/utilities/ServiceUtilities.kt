package com.example.harrypotterapp.data.utilities

import com.example.harrypotterapp.data.api.Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceUtilities{
    val BASE_URL = "https://hp-api.onrender.com/api/"
    fun makeService(): Service {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)

    }
}