package com.francisco.chatappandroid.Scenes.Login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.francisco.chatappandroid.MainActivity
import com.francisco.chatappandroid.Network.APIBuilder
import com.francisco.chatappandroid.Model.Company
import com.francisco.chatappandroid.Model.User
import com.francisco.chatappandroid.Network.APICompanyClient
import com.francisco.chatappandroid.Network.APIUserClient
import com.francisco.chatappandroid.R

interface LoginViewInterface {
    fun networkError(error:Error)
    fun login(user: User)
    fun login(company: Company)
    fun selectLoginMode(loginAsCompany: Boolean)
}

class LoginActivity : AppCompatActivity(), LoginViewInterface {
    private var loginCtrler = LoginCtrler(this,
        APIBuilder().getRetrofitBuilder(APIUserClient::class.java),
        APIBuilder().getRetrofitBuilder(APICompanyClient::class.java))
    private var textView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button = findViewById<Button>(R.id.loginButton)
        textView = findViewById<EditText>(R.id.userNameEditText)
        button.setOnClickListener(View.OnClickListener {
            textView?.let {
                loginCtrler.loginAction(User(it.text.toString()))
            }
        })
    }

    override fun onDestroy() {
        loginCtrler?.onDestroy()
        super.onDestroy()
    }

    override fun networkError(error: Error) {
        Toast.makeText(
            this,
            error.message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun login(user: User) {
        val intentResult = Intent(this@LoginActivity, MainActivity::class.java)
        setResult(Activity.RESULT_OK, intentResult)
        finish()
    }

    override fun login(company: Company) {
        TODO("Not yet implemented")
    }

    override fun selectLoginMode(loginAsCompany: Boolean) {
        TODO("Not yet implemented")
    }
}
