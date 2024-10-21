package com.clubin.com.ui.auth.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.clubin.com.base.BaseViewModel
import com.clubin.com.network.Resource
import com.clubin.com.ui.auth.signup.model.repo.RegisterRepository
import com.clubin.com.ui.auth.login.model.LoginResponse
import com.clubin.com.ui.auth.login.model.repo.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(
    private val repository: AuthRepository
) : BaseViewModel(repository) {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = repository.login(email, password)
    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        repository.saveAccessTokens(accessToken, refreshToken)
    }
}