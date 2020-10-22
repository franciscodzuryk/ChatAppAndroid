package com.francisco.chatappandroid.Model

data class Message (
    val id: Int,
    val message: String
) {
    companion object {
        lateinit var instance: Message
    }

    constructor(message: String) : this(id = -1, message = "")

}