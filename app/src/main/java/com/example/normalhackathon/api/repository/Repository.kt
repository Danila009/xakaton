package com.example.normalhackathon.api.repository

import com.example.normalhackathon.api.RetrofitIns
import com.example.normalhackathon.model.EventGet
import com.example.normalhackathon.model.UserAddPost
import com.example.normalhackathon.model.UserHeader
import com.example.normalhackathon.model.UserPost
import retrofit2.Response

class Repository {

    suspend fun postUser(userPost: UserPost):Response<UserHeader>{
        return RetrofitIns.api.postUser(userPost)
    }

    suspend fun postAddUser(userAddPost: UserAddPost){
        RetrofitIns.api.postUserAddPost(userAddPost)
    }

    suspend fun getEvent(token:String):Response<List<EventGet>>{
        return RetrofitIns.api.getEvent(token)
    }
}