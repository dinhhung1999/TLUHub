package com.example.tlu_hub.model.student

import com.google.gson.annotations.SerializedName

data class faculty(
        @SerializedName("id")
        val id : Int,

        @SerializedName("code_faculty")
        val code_faculty : String,

        @SerializedName("name_faculty")
        val name_faculty : String,

        @SerializedName("published_at")
        val published_at : String,

        @SerializedName("created_at")
        val created_at : String,

        @SerializedName("updated_at")
        val updated_at : String,

)
