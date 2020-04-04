package com.francisco.chatappandroid.Model

data class User (
    val name: String,
    val id: Int,
    val available: Boolean,
    val msgCount: Int
) {
    companion object {
        lateinit var instance: User
    }
    constructor (name: String) : this(name, -1, false, -1)
}