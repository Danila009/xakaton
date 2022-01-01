package com.example.normalhackathon.Screen.BottomBarScreen

import android.content.Intent
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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.normalhackathon.Screen.MainScreen
import com.example.normalhackathon.model.Rating
import com.example.normalhackathon.ui.theme.gol0

@Composable
fun RatingScreen(
    navController: NavHostController,
    fio:String
) {
    val ratingList = ArrayList<Rating>()
    ratingList.add(
        Rating(
            "1",
            "name",
            "1",
            "10",
            "100"
        )
    )
    MainScreen(navController = navController, content = {
        LazyColumn(content = {
            items(ratingList){ rating->
                repeat(100){
                    LazyParticipant(
                        data = rating,
                        time = it
                    )
                }
            }
        }, modifier = Modifier.background(gol0))
    }, fio = fio)
}

@Composable
private fun LazyParticipant(
    data:Rating,
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
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = data.name,
                            modifier = Modifier.padding(5.dp),
                            style = MaterialTheme.typography.body2
                        )
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Баллы: ${data.balls + time}",
                            )
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Место: ${data.rate + time}/${data.size + time}",
                        )
                    }
                }
            }
        }
    }
}