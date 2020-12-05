package com.example.tlu_hub.model.Post

import com.google.gson.annotations.SerializedName

data class Post(
        @SerializedName("id")
        val id : Int,
        @SerializedName("title_posts")
        val title_posts : String,
        @SerializedName("content_posts")
        val content_posts : String,
        @SerializedName("starttime_posts")
        val starttime_posts : String,
        @SerializedName("endtime_posts")
        val endtime_posts : String,
        @SerializedName("link_posts")
        val link_posts : String,
        @SerializedName("id")
        val category: category,
        @SerializedName("published_at")
        val published_at : String,
        @SerializedName("created_at")
        val created_at : String,
        @SerializedName("updated_at")
        val updated_at : String,
        @SerializedName("images_posts")
        val images_posts : imagePost,



)