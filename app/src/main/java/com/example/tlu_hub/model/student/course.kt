package com.example.tlu_hub.model.student

import com.google.gson.annotations.SerializedName

data class course (
        @SerializedName("id")
        val id : Int,

        @SerializedName("code_course")
        val code_course : String,


        @SerializedName("published_at")
        val published_at : String,


        @SerializedName("created_at")
        val created_at : String,


        @SerializedName("updated_at")
        val updated_at : String,

)