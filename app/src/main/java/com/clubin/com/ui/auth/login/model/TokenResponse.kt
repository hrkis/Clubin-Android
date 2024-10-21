package com.clubin.com.ui.auth.login.model

data class TokenResponse(
    val access_token: String?,
    val refresh_token: String?
)