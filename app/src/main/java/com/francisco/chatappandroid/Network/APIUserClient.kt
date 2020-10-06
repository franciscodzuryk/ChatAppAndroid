package com.francisco.chatappandroid.Network

import com.francisco.chatappandroid.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIUserClient {
    @POST("/user/login/")
    fun login(@Body user: User): Call<User>

    @POST(value = "/user//logout/")
    fun logout(@Body user: User): Call<User>

    @POST(value = "/user//message/")
    fun sendMessage(@Body user: User): Call<User>

    @GET(value = "/user//message/")
    fun getMessage(@Body user: User): Call<User>
}
