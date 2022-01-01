package com.example.normalhackathon.model

import com.google.gson.annotations.SerializedName

data class UserHeader(
    @SerializedName("access_token")
    var token:String,
    val expires:String,
    val username:String,
    var role: String
)