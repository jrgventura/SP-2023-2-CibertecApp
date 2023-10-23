package com.cibertec.cibertecapp.network

import com.cibertec.cibertecapp.network.request.LoginRequest
import com.cibertec.cibertecapp.network.response.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface CibertecApi {

    @POST("/login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

}