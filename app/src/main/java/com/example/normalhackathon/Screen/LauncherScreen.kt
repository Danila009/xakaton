package com.example.normalhackathon.Screen

import android.os.CountDownTimer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.normalhackathon.R
import com.example.normalhackathon.navigation.LOGIN_ROUTE
import com.example.normalhackathon.navigation.MAIN_ROUTE
import com.example.normalhackathon.ui.theme.biruzoviy
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LauncherScreen(
    navController: NavController
) {
    Box(Modifier.background(biruzoviy)) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logoe),
                contentDescription = null
            )
        }
    }

    val scope = rememberCoroutineScope()
    val timer = object : CountDownTimer(2000,1000) {
        override fun onTick(millisUntilFinished: Long) {
        }
        override fun onFinish() {
            scope.launch {
                navController.navigate(LOGIN_ROUTE)
            }
        }
    }
    timer.start()
}