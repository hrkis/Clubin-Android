package com.clubin.com.network

import com.clubin.com.ui.auth.login.model.LoginResponse
import com.clubin.com.ui.auth.login.model.TokenResponse
import com.clubin.com.ui.auth.signup.model.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AllApi : BaseApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @FormUrlEncoded
    @POST("auth/register")
    suspend fun register(
        @Field("name") name: String,
        @Field("age") age: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("auth/refresh-token")
    suspend fun refreshAccessToken(
        @Field("refresh_token") refreshToken: String?
    ): TokenResponse

    @GET("user")
    suspend fun getUser(): LoginResponse
}