package com.example.normalhackathon.navigation.nav_graph

import androidx.activity.OnBackPressedDispatcherOwner
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.normalhackathon.Screen.BottomBarScreen.EventScreen
import com.example.normalhackathon.Screen.BottomBarScreen.ProfileScreen
import com.example.normalhackathon.Screen.BottomBarScreen.RatingScreen
import com.example.normalhackathon.api.MainViewModel
import com.example.normalhackathon.navigation.ARGUMENT_FIO
import com.example.normalhackathon.navigation.MAIN_ROUTE
import com.example.normalhackathon.navigation.Screen
import com.example.normalhackathon.utils.Constants

fun NavGraphBuilder.bottomBarNavGraph(
    navHostController: NavHostController,
    viewModel: MainViewModel,
    owner: OnBackPressedDispatcherOwner
){
    navigation(
        startDestination = Screen.Event.route,
        route = MAIN_ROUTE,
        builder = {
            composable(Screen.Event.route, content = {
                EventScreen(
                    navController = navHostController,
                    viewModel = viewModel,
                    owner = owner,
                    fio = Constants.userName
                )
            })
            composable(Screen.Rating.route, content = {
                RatingScreen(
                    navController = navHostController,
                    fio = Constants.userName
                )
            })
            composable(Screen.Profile.route, content = {
                ProfileScreen(
                    navController = navHostController,
                    fio = it.arguments?.getString(ARGUMENT_FIO)!!.toString()
                )
            }, arguments = listOf(
                navArgument(
                    name = ARGUMENT_FIO,
                    builder = {
                        type = NavType.StringType
                    }
                )
            ))
        }
    )
}