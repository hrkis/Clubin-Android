package com.clubin.com.ui.auth.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.clubin.com.network.Resource
import com.clubin.com.ui.auth.signup.model.repo.RegisterRepository
import com.clubin.com.ui.auth.signup.model.RegisterResponse
import com.clubin.com.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupVM @Inject constructor(
    private val repository: RegisterRepository
) : BaseViewModel(repository) {

    private val _registerResponse: MutableLiveData<Resource<RegisterResponse>> = MutableLiveData()
    val registerResponse: LiveData<Resource<RegisterResponse>>
        get() = _registerResponse

    fun register(
        name: String,
        age: String,
        email: String,
        password: String
    ) = viewModelScope.launch {
        _registerResponse.value = Resource.Loading
        _registerResponse.value = repository.register(name, age, email, password)
    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        repository.saveAccessTokens(accessToken, refreshToken)
    }
}