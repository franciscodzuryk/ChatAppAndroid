package com.francisco.chatappandroid.Network

import com.francisco.chatappandroid.Model.Message
import com.francisco.chatappandroid.Model.Status
import com.francisco.chatappandroid.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIUserClient {
    @POST("/user/login")
    fun login(@Body user: User): Call<User>

    @POST("/user/{id_user}/logout")
    fun logout(@Path("id_user") userId: Int, @Body user: User): Call<User>

    @GET("/user")
    fun userList(): Call<List<User>>

    @GET("/user/{id_user}/message")
    fun getMessages(@Path("id_user") userId: Int): Call<List<Message>>

    @POST("/user/{id_user}/message")
    fun sendMessage(@Path("id_user") userId: Int, @Body message: Message): Call<Status>
}
