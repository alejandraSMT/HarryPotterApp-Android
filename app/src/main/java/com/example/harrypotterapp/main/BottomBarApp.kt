package com.example.harrypotterapp.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.harrypotterapp.ui.theme.bottomBar
import com.example.harrypotterapp.ui.theme.selectedIcon

@Composable
fun BottomBarApp(
    navController: NavHostController,
    state: MutableState<Boolean>,
) {
    val screens = listOf(
        NavIcons.Houses,
        NavIcons.Staff,
        NavIcons.Spells
    )

    NavigationBar(
        modifier = Modifier
            .height(75.dp)
            .fillMaxWidth(),
        containerColor = bottomBar,
        tonalElevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->

            NavigationBarItem(
                label = {
                    Text(
                        text = screen.title,
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = "",
                        tint = Color.White
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }},
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedIcon,
                    unselectedIconColor = Color.Transparent
                )
            )
        }

    }

}