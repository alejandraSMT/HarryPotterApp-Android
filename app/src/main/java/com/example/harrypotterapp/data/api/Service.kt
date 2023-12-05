package com.example.harrypotterapp.data.api

import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.model.Spell
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("characters/staff")
    suspend fun getStaff(): Response<List<Character>>

    @GET("characters/house/{house}")
    suspend fun getCharactersByHouse(
        @Path("house") house : String
    ) :Response<List<Character>>

    @GET("character/{id}")
    suspend fun getCharacterInfo(
        @Path("id") id : String
    ) : Response<List<Character>>

    @GET("spells")
    suspend fun getSpells() : Response<List<Spell>>

}