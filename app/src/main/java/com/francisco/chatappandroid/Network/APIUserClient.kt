package com.francisco.chatappandroid.Network

import com.francisco.chatappandroid.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIUserClient {
    @POST("/user/login/")
    fun login(@Body user: User): Call<User>

    @POST(value = "/user//logout/")
    fun logout(@Body user: User): Call<User>

    @POST(value = "/user/{user_id}/message/")
    fun sendMessage(@Path("user_id") userId: Int, @Body user: User): Call<User>

    @GET(value = "/user/{user_id}/message/")
    fun getMessages(@Path("user_id") userId: Int): Call<User>

    @GET(value = "/user//message/")
    fun getStatus(): Call<User>
}
