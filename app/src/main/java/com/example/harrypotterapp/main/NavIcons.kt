package com.example.harrypotterapp.main

import com.example.harrypotterapp.R

sealed class NavIcons(
    val route: String,
    val title: String,
    val icon: Int
){
    object Houses : NavIcons(
        route = "houses",
        title = "Houses",
        icon = R.drawable.houses_icon
    )

    object Staff : NavIcons(
        route = "staff",
        title = "Staff",
        icon = R.drawable.staff_icon
    )

    object Spells : NavIcons(
        route = "spells",
        title = "Spells",
        icon = R.drawable.spells_icon
    )


}


