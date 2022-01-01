package com.example.normalhackathon.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.normalhackathon.api.repository.Repository
import com.example.normalhackathon.model.EventGet
import com.example.normalhackathon.model.UserAddPost
import com.example.normalhackathon.model.UserPost
import com.example.normalhackathon.navigation.MAIN_ROUTE
import com.example.normalhackathon.navigation.Screen
import com.example.normalhackathon.utils.Constants
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: Repository):ViewModel() {

    val eventResponse:MutableLiveData<List<EventGet>> = MutableLiveData()

    fun postUser(userPost: UserPost, navController: NavController){
        viewModelScope.launch {
            try {
                val response = repository.postUser(userPost)
                if (response.isSuccessful){
                    val data = response.body()
                    Constants.token = data?.token
                    Constants.userName = data?.username.toString()
                    when(data?.role){
                        "Jury" -> {
                            navController.navigate(MAIN_ROUTE)
                        }
                        "Accessor" -> {
                            navController.navigate(MAIN_ROUTE)
                        }
                        "Contestant" -> {
                            navController.navigate(MAIN_ROUTE)
                        }
                        "Admin" ->{
                            navController.navigate(MAIN_ROUTE)
                        }
                    }
                }
            }catch (e:Exception){

            }
        }
    }

    fun postAddUser(userAddPost: UserAddPost, navController: NavController){
        viewModelScope.launch {
            try {
                repository.postAddUser(userAddPost)
                postUser(
                    UserPost(
                        email = userAddPost.email,
                        password = userAddPost.password
                    ),
                    navController
                )
            }catch (e:Exception){

            }
        }
    }

    fun getEvent(){
        viewModelScope.launch {
            try {
                val response = repository.getEvent("Bearer ${Constants.token!!}")
                Log.d("event",Constants.token.toString())
                if (response.isSuccessful){
                    val data = response.body()
                    eventResponse.value = data
                    Log.d("event",data.toString())
                }
            }catch (e:Exception){
                Log.d("event",e.message.toString())
            }
        }
    }
}