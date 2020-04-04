package com.francisco.chatappandroid.Utils

import android.content.Context
import com.francisco.chatappandroid.Model.User
import com.google.gson.Gson




class LocalStorage(context: Context) {
    val PREFERENCE_NAME = "ChatAppPreference"
    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun setDemoMode(demoMode: Boolean)
    {
        val editor = preference.edit()
        editor.putBoolean("DemoMode", demoMode)
        editor.commit()
    }

    fun isDemoMode(): Boolean
    {
        return preference.getBoolean("DemoMode",false)
    }

    fun setLoggedAsCompany(companyMode: Boolean)
    {
        val editor = preference.edit()
        editor.putBoolean("LoggedAsCompany", companyMode)
        editor.commit()
    }

    fun isLoggedAsCompany(): Boolean
    {
        return preference.getBoolean("LoggedAsCompany",false)
    }

    fun setUser(user: User)
    {
        val json = Gson().toJson(user)
        val editor = preference.edit()
        editor.putString("User", json)
        editor.commit()
    }

    fun getUser(): User?
    {
        val json = preference.getString("User","")
        return Gson().fromJson(json, User::class.java)
    }

    fun setLoginName(loginName: String)
    {
        val editor = preference.edit()
        editor.putString("LoginName", loginName)
        editor.commit()
    }

    fun getLoginName(): String
    {
        return preference.getString("LoginName","")
    }
}