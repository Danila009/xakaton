package com.example.normalhackathon.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.normalhackathon.R
import com.example.normalhackathon.navigation.BottomBarScreen
import com.example.normalhackathon.navigation.Screen
import com.example.normalhackathon.ui.theme.biruzoviy
import com.example.normalhackathon.ui.theme.gol0

@Composable
fun MainScreen(
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit,
    fio:String
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
        topBar = { TobBar(nanController = navController, fio = fio)},
        content = content
    )
}

@Composable
private fun TobBar(nanController: NavHostController, fio:String) {
    TopAppBar(
        title = { Text(text = fio, color = Color.White) },
        backgroundColor = biruzoviy,
        navigationIcon = {
            Box(
                modifier = Modifier
                    .background(
                        shape = CircleShape,
                        color = Color.Black
                    )
                    .size(40.dp)
            ) {
                IconButton(
                    onClick = {
                    },
                    Modifier
                        .background(
                            shape = CircleShape,
                            color = Color.Black
                        )
                        .size(40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image),
                        contentDescription = null,
                        Modifier
                            .background(
                                shape = CircleShape,
                                color = Color.Black
                            ).clip(CircleShape),
                    )
                }
            }
        })
}

@Composable
private fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Event,
        BottomBarScreen.Rating,
        BottomBarScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        contentColor = Color.White,
        backgroundColor = gol0
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
private fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = null,
                tint = if (screen.route == currentDestination?.route) biruzoviy else LocalContentColor.current.copy(
                    alpha = LocalContentAlpha.current
                )
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}