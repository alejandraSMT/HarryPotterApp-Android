package com.example.harrypotterapp.data


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    var actor: String,
    var alive: Boolean,
    @SerializedName("alternate_actors")
    var alternateActors: List<Any>,
    @SerializedName("alternate_names")
    var alternateNames: List<String>,
    var ancestry: String,
    var dateOfBirth: String,
    var eyeColour: String,
    var gender: String,
    var hairColour: String,
    var hogwartsStaff: Boolean,
    var hogwartsStudent: Boolean,
    var house: String,
    var id: String,
    var image: String,
    var name: String,
    var patronus: String,
    var species: String,
    var wand: Wand,
    var wizard: Boolean,
    var yearOfBirth: Int
)