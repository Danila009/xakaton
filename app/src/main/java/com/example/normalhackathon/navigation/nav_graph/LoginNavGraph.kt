package com.example.normalhackathon.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.normalhackathon.Screen.LoginScreen
import com.example.normalhackathon.api.MainViewModel
import com.example.normalhackathon.navigation.LOGIN_ROUTE
import com.example.normalhackathon.navigation.Screen

fun NavGraphBuilder.loginNavGraph(
    navHostController: NavHostController,
    viewModel:MainViewModel
){
    navigation(
        startDestination = Screen.Login.route,
        route = LOGIN_ROUTE,
        builder = {
            composable(Screen.Login.route, content = {
                LoginScreen(
                    navController = navHostController,
                    viewModel
                )
            })
        }
    )
}