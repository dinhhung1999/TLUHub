package com.example.tlu_hub.model.Post

import com.google.gson.annotations.SerializedName

data class category(
        @SerializedName("id")
        val id : Int,

        @SerializedName("name_category")
        val name_category : String,

        @SerializedName("published_at")
        val published_at : String,

        @SerializedName("created_at")
        val created_at : String,

        @SerializedName("updated_at")
        val updated_at : String,
)