package com.example.normalhackathon.navigation.nav_graph

import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.normalhackathon.api.MainViewModel
import com.example.normalhackathon.navigation.LAUNCHER_ROUTE
import com.example.normalhackathon.navigation.ROOT_GRAPH_ROUTE

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    viewModel: MainViewModel,
    owner: OnBackPressedDispatcherOwner
) {
    NavHost(
        navController = navController,
        startDestination = LAUNCHER_ROUTE,
        route = ROOT_GRAPH_ROUTE,
        builder = {
            launcherNavGraph(navHostController = navController)
            loginNavGraph(
                navHostController = navController,
                viewModel = viewModel
            )
            bottomBarNavGraph(
                navHostController = navController,
                viewModel = viewModel,
                owner = owner
            )
        }
    )
}