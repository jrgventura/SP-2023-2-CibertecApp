package com.cibertec.cibertecapp.network

import com.cibertec.cibertecapp.network.request.LoginRequest
import com.cibertec.cibertecapp.network.response.LoginResponse
import com.cibertec.cibertecapp.network.response.UsersResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface CibertecApi {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    @GET("users") // users?page=2&number=100
    fun getUserList(@Query("page") page: Int,
                    @Query("number") number: Int):
            Single<UsersResponse>

    @GET("users/{id}") // users/2
    fun getUser(@Path("id") id: Int): Single<UsersResponse>


}