package com.clubin.com.ui.auth.login.model.repo


import com.clubin.com.base.BaseRepository
import com.clubin.com.network.AllApi
import com.clubin.com.utills.UserPreferences
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: AllApi,
    private val preferences: UserPreferences
) : BaseRepository(api) {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }


    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        preferences.saveAccessTokens(accessToken, refreshToken)
    }

}