package com.example.tlu_hub.model.category

import com.example.tlu_hub.model.Post.imagePost
import com.google.gson.annotations.SerializedName

data class posts (
        @SerializedName("id")
        val id : Int,

        @SerializedName("title_posts")
        val title_posts : String,

        @SerializedName("content_posts")
        val content_posts : String,

        @SerializedName("starttime_posts")
        val starttime_posts : String,

        @SerializedName("link_posts")
        val link_posts : String,

        @SerializedName("images_posts")
        val images_posts : imagePost,

        @SerializedName("category")
        val category : String,

        @SerializedName("published_at")
        val published_at : String,

        @SerializedName("created_by")
        val created_by : String,

        @SerializedName("updated_by")
        val updated_by : String,
)