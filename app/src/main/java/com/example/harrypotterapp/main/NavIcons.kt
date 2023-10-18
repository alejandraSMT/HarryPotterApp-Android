package com.example.harrypotterapp.main

import android.graphics.drawable.Icon
import android.media.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.harrypotterapp.R

sealed class NavIcons(
    val route: String,
    val title: String,
    val icon: Int
){
    object Houses : NavIcons(
        route = "houses",
        title = "Houses",
        icon = R.drawable.arrow
    )

    object Staff : NavIcons(
        route = "staff",
        title = "Staff",
        icon = R.drawable.arrow
    )

    object Spells : NavIcons(
        route = "spells",
        title = "Spells",
        icon = R.drawable.arrow
    )


}


