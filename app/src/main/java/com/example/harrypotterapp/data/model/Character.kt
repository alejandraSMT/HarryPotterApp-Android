package com.example.harrypotterapp.data.model

data class Character (

    val actor: String?="",
    val alive: Boolean?=null,
    val alternateActors: List<Any>?= emptyList(),
    val alternateNames: List<String>?= emptyList(),
    val ancestry: String?="",
    val dateOfBirth: String?=null,
    val eyeColour: String?="",
    val gender: String?="",
    val hairColour: String?="",
    val hogwartsStaff: Boolean?=null,
    val hogwartsStudent: Boolean?=null,
    val house: String?="",
    val id: String?="",
    val image: String?="",
    val name: String?="",
    val patronus: String?="",
    val species: String?="",
    val wand: Wand?=null,
    val wizard: Boolean?=null,
    val yearOfBirth: Int?=null
)