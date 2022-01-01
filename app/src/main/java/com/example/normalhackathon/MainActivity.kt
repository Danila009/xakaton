package com.example.normalhackathon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.normalhackathon.api.MainViewModel
import com.example.normalhackathon.api.ViewModelFactory
import com.example.normalhackathon.api.repository.Repository
import com.example.normalhackathon.navigation.nav_graph.SetupNavGraph
import com.example.normalhackathon.ui.theme.NormalHackathonTheme

class MainActivity : ComponentActivity() {
    lateinit var navController:NavHostController
    lateinit var viewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        setContent {
            navController = rememberNavController()
            SetupNavGraph(
                navController = navController,
                viewModel = viewModel,
                owner = this
            )
        }
    }
}