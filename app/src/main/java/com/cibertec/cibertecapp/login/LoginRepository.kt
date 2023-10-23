package com.cibertec.cibertecapp.login

import com.cibertec.cibertecapp.network.ApiService
import com.cibertec.cibertecapp.network.request.LoginRequest
import com.cibertec.cibertecapp.network.response.LoginResponse
import com.cibertec.cibertecapp.network.response.UsersResponse
import io.reactivex.Single

class LoginRepository {

    private val api = ApiService().apiService

    fun login(email: String, pass: String): Single<LoginResponse>{
        return api.login(LoginRequest(email, pass))
    }

    fun buscarUsuario(id: Int): Single<UsersResponse>{
        return api.getUser(id)
    }

}