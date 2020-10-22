package com.francisco.chatappandroid.Network

import com.francisco.chatappandroid.Model.Message
import com.francisco.chatappandroid.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIUserClient {

    @POST("/user/login/")
    fun login(@Body user: User): Call<User>

    @POST(value = "/user/{user_id}/logout/")
    fun logout(@Path("user_id") userId: Int): Call<User>

    // enviar mensaje a un usuario.
    @POST(value = "/user/{user_id}/message/")
    fun sendMessage(@Path("user_id") userId: Int, @Body message: Message): Call<Message>

    // obtener mensajes de un usuario, una vez devuelta la respuesta los mensajes
    // son eliminados del servidor.
    @GET(value = "/user/{user_id}/message/")
    fun getMessages(@Path("user_id") userId: Int): Call<Message>
}
