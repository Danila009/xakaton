package com.example.normalhackathon.api

import com.example.normalhackathon.model.*
import com.example.normalhackathon.utils.Constants.Companion.GET_EVENT_URL
import com.example.normalhackathon.utils.Constants.Companion.HEADER_VALUE
import com.example.normalhackathon.utils.Constants.Companion.POST_Add_USER_URL
import com.example.normalhackathon.utils.Constants.Companion.POST_USER_URL
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TavolgaAPI {

    @POST(POST_USER_URL)
    suspend fun postUser(
        @Body user:UserPost
    ):Response<UserHeader>

    @POST(POST_Add_USER_URL)
    suspend fun postUserAddPost(
        @Body user:UserAddPost
    )

    @GET(GET_EVENT_URL)
    suspend fun getEvent(
        @Header(HEADER_VALUE) token:String
    ):Response<List<EventGet>>
}