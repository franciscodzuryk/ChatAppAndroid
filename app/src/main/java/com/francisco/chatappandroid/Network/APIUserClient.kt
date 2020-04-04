package com.francisco.chatappandroid.Network

import com.francisco.chatappandroid.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIUserClient {
    @POST("/user/login/")
    fun login(@Body user: User): Call<User>
}