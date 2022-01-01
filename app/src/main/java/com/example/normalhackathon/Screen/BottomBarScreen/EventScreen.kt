package com.example.normalhackathon.Screen.BottomBarScreen

import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.normalhackathon.Screen.MainScreen
import com.example.normalhackathon.api.MainViewModel
import com.example.normalhackathon.model.EventGet
import com.example.normalhackathon.ui.theme.gol0

@Composable
fun EventScreen(
    navController: NavHostController,
    viewModel: MainViewModel,
    owner:OnBackPressedDispatcherOwner,
    fio:String
) {
    MainScreen(navController = navController, content = {
        viewModel.getEvent()
        var eventList by remember {
            mutableStateOf(listOf<EventGet>())
        }
        viewModel.eventResponse.observe(owner, {
            eventList = it
        })
        LazyColumn(content = {
            items(eventList){ event->
                repeat(100){
                    HomeLazyEvent(
                        data = event,
                        time = it
                    )
                }
            }
        }, modifier = Modifier.background(gol0))
    }, fio = fio)
}

@Composable
private fun HomeLazyEvent(
    data:EventGet,
    time:Int
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {

            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {

                    })
                }) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = data.name + time,
                        modifier = Modifier.padding(5.dp),
                        style = MaterialTheme.typography.body2
                    )
                }

                Text(
                    text = data.description + time,
                    modifier = Modifier.padding(5.dp)
                )

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Количество участников: 1$time",
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}