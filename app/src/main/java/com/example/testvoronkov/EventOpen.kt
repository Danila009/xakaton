package com.example.testvoronkov

import android.media.metrics.Event
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.testvoronkov.ui.theme.JetHabbitStyle
import com.example.testvoronkov.ui.theme.JetHabbitTheme
import com.example.testvoronkov.ui.theme.MainThem
import com.example.testvoronkov.ui.theme.TestVoronkovTheme

class EventOpen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val darkVakue = isSystemInDarkTheme()

            val currentStyle = remember { mutableStateOf(JetHabbitStyle.TextPrimary) }
            val isDarkMode = remember { mutableStateOf(darkVakue) }

            MainThem(
                style = currentStyle.value,
                darkThem = isDarkMode.value
            ) {
                Event()
            }
        }
    }
    @Preview
    @Composable
    fun Event() {
        val id = intent.getStringExtra("id")!!.toInt()
        val name = intent.getStringExtra("name").toString()
        val description = intent.getStringExtra("Description").toString()
        val nominations = intent.getStringExtra("Nominations").toString()
        val participant = intent.getStringExtra("participant").toString()
        val date = intent.getStringExtra("date").toString()

        Scaffold(topBar = {
            TopAppBar(title = {
                Text(text = name, color = JetHabbitTheme.colors.primaryText)
            }, navigationIcon = {
                IconButton(onClick = {
                    finish()
                }) {
                    Icon(painter = painterResource(id = R.drawable.before_24), contentDescription = null, modifier = Modifier.size(64.dp).padding(top = 8.dp))
                }
            },backgroundColor = JetHabbitTheme.colors.primaryBackground
            )
        }) {

            Column(
                Modifier
                    .fillMaxSize()
                    .background(JetHabbitTheme.colors.primaryBackground)) {

                Text(text = nominations, color = JetHabbitTheme.colors.primaryText, modifier = Modifier.padding(5.dp))
                Divider(modifier = Modifier.padding(bottom = 4.dp),thickness = 1.dp)

                Text(text = description, color = JetHabbitTheme.colors.primaryText, modifier = Modifier.padding(5.dp))
                Divider(modifier = Modifier.padding(bottom = 4.dp),thickness = 1.dp)

                Text(text = participant, color = JetHabbitTheme.colors.primaryText, modifier = Modifier.padding(5.dp))
                Divider(modifier = Modifier.padding(bottom = 4.dp),thickness = 1.dp)


                Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End,modifier = Modifier.fillMaxSize().padding(8.dp)) {
                    Text(text = date, color = JetHabbitTheme.colors.primaryText)
                }
            }
        }
    }
}

