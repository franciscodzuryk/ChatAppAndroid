package com.francisco.chatappandroid.Scenes.Login

import com.francisco.chatappandroid.Model.User
import com.francisco.chatappandroid.Network.APICompanyClient
import com.francisco.chatappandroid.Network.APIUserClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginCtrler (var view: LoginViewInterface?, val apiUserClient: APIUserClient, val apiCompanyClient: APICompanyClient) {

    fun onDestroy() {
        view = null
    }

    private fun loginAction(user: User) {
        val call: Call<User>
        call = apiUserClient.login(user)
        call.enqueue(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                val user = response.body()?.let {
                    User.instance = user
                    view?.login(user)
                } ?: run {
                    view?.networkError(Error("Server Error. Try again later"))
                }

            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                view?.networkError(Error("Server Error. Try again later", t))
            }
        })
    }
}