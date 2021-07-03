package com.francisco.chatappandroid.Network

import com.francisco.chatappandroid.Model.Company
import com.francisco.chatappandroid.Model.Message
import com.francisco.chatappandroid.Model.Status
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APICompanyClient {
    @POST("/company/login")
    fun login(@Body company: Company): Call<Company>

    @POST("/company/logout")
    fun logout(@Body company: Company): Call<Company>

    @GET("/company/status")
    fun status(): Call<Status>

    @GET("/company/message/user/{id_user}")
    fun getMessages(@Path("id_user") userId: Int): Call<List<Message>>

    @GET("/company/message")
    fun getAllMessages(): Call<List<Message>>

    @POST("/company/message")
    fun sendMessage(@Body message: Message): Call<Status>
}
