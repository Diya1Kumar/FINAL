package com.example.pnlanalyser.network

import com.google.firebase.firestore.auth.User

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
data class RegisterRequest(val username: String, val password: String)
data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String)
interface ApiService {

    @POST("/register")
    fun register(@Body request: RegisterRequest): Call<Void>

    @POST("/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
