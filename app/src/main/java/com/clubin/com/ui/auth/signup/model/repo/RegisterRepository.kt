package com.clubin.com.ui.auth.signup.model.repo


import com.clubin.com.base.BaseRepository
import com.clubin.com.network.AllApi
import com.clubin.com.utills.UserPreferences
import javax.inject.Inject

class RegisterRepository @Inject constructor(
    private val api: AllApi,
    private val preferences: UserPreferences
) : BaseRepository(api) {

    suspend fun register(
        name: String,
        age: String,
        email: String,
        password: String
    ) = safeApiCall {
        api.register(name, age, email, password)
    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        preferences.saveAccessTokens(accessToken, refreshToken)
    }

}