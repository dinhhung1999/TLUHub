package com.example.tlu_hub.model.userData

import com.google.gson.annotations.SerializedName

data class UserData(
        @SerializedName("jwt")
        val token: String,

        @SerializedName("user")
        val user: user,
)