package com.example.tlu_hub.model.category

import com.google.gson.annotations.SerializedName

data class Category(

        @SerializedName("id")
        val id : Int,

        @SerializedName("name_category")
        val name_category : String,

        @SerializedName("published_at")
        val published_at : String,

        @SerializedName("posts")
        val posts : ArrayList<posts>

)