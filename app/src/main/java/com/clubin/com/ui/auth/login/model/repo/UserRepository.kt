package com.clubin.com.ui.auth.login.model.repo


import com.clubin.com.base.BaseRepository
import com.clubin.com.network.AllApi
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: AllApi
) : BaseRepository(api) {

    suspend fun getUser() = safeApiCall { api.getUser() }

}