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

    fun loginAction(user: User) {
        val call: Call<User>
        call = apiUserClient.login(user)
        call.enqueue(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                response.body()?.let {
                    User.instance = it
                    view?.login(it)
                } ?: run {
                    view?.networkError(Error("Error parsing User object on login method"))
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                view?.networkError(Error("Server Error. Try again later", t))
            }
        })
    }
}