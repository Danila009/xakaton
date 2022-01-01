package com.example.normalhackathon.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.normalhackathon.Screen.LauncherScreen
import com.example.normalhackathon.navigation.LAUNCHER_ROUTE
import com.example.normalhackathon.navigation.Screen

fun NavGraphBuilder.launcherNavGraph(
    navHostController: NavHostController
){
    navigation(
        startDestination = Screen.Launcher.route,
        route = LAUNCHER_ROUTE,
        builder = {
            composable(Screen.Launcher.route, content = {
                LauncherScreen(navController = navHostController)
            })
        }
    )
}