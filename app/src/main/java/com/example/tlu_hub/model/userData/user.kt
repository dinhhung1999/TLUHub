package com.example.tlu_hub.model.userData

import com.google.gson.annotations.SerializedName

class user(
        @SerializedName("id")
        val id : Int,

        @SerializedName("username")
        val username : String,

        @SerializedName("email")
        val email : String,

        @SerializedName("provider")
        val provider : String,

        @SerializedName("confirmed")
        val confirmed : Boolean,

        @SerializedName("blocked")
        val blocked : Boolean,

        @SerializedName("role")
        val role: role,

        @SerializedName("created_at")
        val created_at: String,

        @SerializedName("updated_at")
        val updated_at: String,

        @SerializedName("code_user")
        val code_user: String,

        @SerializedName("student")
        val student: Int,
)