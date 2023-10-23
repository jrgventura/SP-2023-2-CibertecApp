package com.cibertec.cibertecapp.network.response

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("page")
    var page: Int,
    @SerializedName("per_page")
    var per_page: Int,
    @SerializedName("total")
    var total: Int,
    @SerializedName("total_pages")
    var total_pages: Int,
    @SerializedName("data")
    var data: ArrayList<User>,
    @SerializedName("support")
    var support: Support
)

data class User(
    @SerializedName("id")
    var id: Int,
    @SerializedName("email")
    var email: String,
    @SerializedName("first_name")
    var first_name: String,
    @SerializedName("last_name")
    var last_name: String,
    @SerializedName("avatar")
    var avatar: String
)

data class Support (
    @SerializedName("url")
    var url: String,
    @SerializedName("text")
    var text: String
)
