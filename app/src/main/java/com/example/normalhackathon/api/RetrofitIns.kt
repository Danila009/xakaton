package com.example.normalhackathon.api

import com.example.normalhackathon.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitIns {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:TavolgaAPI by lazy {
        retrofit.create(TavolgaAPI::class.java)
    }
}