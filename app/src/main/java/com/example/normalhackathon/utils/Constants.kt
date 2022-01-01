package com.example.normalhackathon.utils

class Constants {
    companion object{
        const val BASE_URL = "https://api.cfif31.ru/api/"
        const val POST_Add_USER_URL = "Account/Register"
        const val POST_USER_URL = "Account"
        const val GET_EVENT_URL = "Event/GetAllFull"

        const val HEADER_VALUE = "Authorization"

        var token:String?=null
        var userName = ""
    }
}