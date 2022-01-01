package com.example.normalhackathon.Screen.BottomBarScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.normalhackathon.R
import com.example.normalhackathon.Screen.MainScreen
import com.example.normalhackathon.ui.theme.biruzoviy
import com.example.normalhackathon.ui.theme.gol0

@Composable
fun ProfileScreen(
    navController: NavHostController,
    fio: String
) {
    MainScreen(navController = navController, fio = fio, content = {
        Profile(fio = fio)
    })
}

@Composable
private fun Profile(fio: String) {
    val arr = listOf(
        "Лучший гражданский служащий Самарской области",
        "Лучший специалист местного самоуправления в Самарской области",
        "Лучший наставник на государственной гражданской службе Самарской области",
        "Лучшие практики и инициативы в системе государственного управления",
        "Лучшие практики и инициативы в системе муниципального управления",
        "Компетентный проектный офис",
        "Таланты региона",
        "Проекты в области бережливого управления",
        "Лучший проект в сфере цифровой трансформации",
        "Проекты в области национально- социальной инициативы",
        "Нет Номинации",
    )
    val dialog = remember {
        mutableStateOf(false)
    }
    val a1 = remember {
        mutableStateOf(false)
    }
    val a2 = remember {
        mutableStateOf(false)
    }
    val a3 = remember {
        mutableStateOf(false)
    }
    val a4 = remember {
        mutableStateOf(false)
    }
    val a5 = remember {
        mutableStateOf(false)
    }
    val a6 = remember {
        mutableStateOf(false)
    }
    val a7 = remember {
        mutableStateOf(false)
    }
    val a8 = remember {
        mutableStateOf(false)
    }
    val a9 = remember {
        mutableStateOf(false)
    }
    val a10 = remember {
        mutableStateOf(false)
    }
    val a11 = remember {
        mutableStateOf(false)
    }
    val checked = remember {
        arrayListOf(
            a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11
        )
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(gol0)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                Modifier
                    .scrollable(rememberLazyListState(), Orientation.Vertical)
                    .fillMaxWidth()
            ) {
                item {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Spacer(modifier = Modifier.size(30.dp))
                        Image(
                            painter = painterResource(id = R.drawable.image),
                            contentDescription = null,
                            Modifier
                                .background(
                                    Color.White, shape = CircleShape
                                )
                                .align(Alignment.CenterHorizontally)
                                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
                                .size(250.dp)
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = {
                                dialog.value = true
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.replaces),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(80.dp)
                                        .padding(end = 15.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(
                            text = fio,
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                        )
                        Spacer(modifier = Modifier.size(20.dp))

                        for (i in arr.indices) {
                            Nom(checked = checked[i], name = arr[i])
                        }

                        Column(Modifier.fillMaxWidth()) {
                            Text(
                                text = "Выйти",
                                color = Color.Red,
                                modifier = Modifier
                                    .clickable {
                                    }
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 100.dp)
                    ) {


                        if (dialog.value) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Nom(checked: MutableState<Boolean>, name: String) {
    Column(
        Modifier
            .padding(horizontal = 5.dp)
            .fillMaxSize()
    ) {
        Row(
            Modifier
                .padding(horizontal = 5.dp)
                .fillMaxSize()
        ) {
            Checkbox(
                checked = checked.value, onCheckedChange = {
                    checked.value = it
                }, colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.Black,
                    checkedColor = biruzoviy
                )
            )
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = name,
                    Modifier
                        .padding(horizontal = 5.dp)
                        .fillMaxWidth(),
                )
            }
        }
    }
}
