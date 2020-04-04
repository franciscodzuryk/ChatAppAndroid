package com.francisco.chatappandroid.Network

import com.francisco.chatappandroid.Model.Company
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APICompanyClient {
    @POST("/user/login/")
    fun login(@Body user: Company): Call<Company>
}