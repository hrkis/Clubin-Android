package com.clubin.com.ui.auth.login.model

import java.io.Serializable

data class User(
    val first_name: String,
    val last_name: String,
    val email: String,
    val age: String,
    val password: String) : Serializable