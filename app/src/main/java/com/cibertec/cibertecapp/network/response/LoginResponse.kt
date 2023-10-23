package com.cibertec.cibertecapp.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    var token: String
)
