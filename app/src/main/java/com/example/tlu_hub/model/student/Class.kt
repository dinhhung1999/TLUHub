package com.example.tlu_hub.model.student

import com.google.gson.annotations.SerializedName

data class Class (
        @SerializedName("id")
        val id: Int,

        @SerializedName("code_class")
        val code_class: String,

        @SerializedName("published_at")
        val published_at: String,

        @SerializedName("created_at")
        val created_at: String,

        @SerializedName("updated_at")
        val updated_at: String,

)