package com.example.tlu_hub.model.userData

import com.google.gson.annotations.SerializedName

data class role(

        @SerializedName("id")
        val id : Int,

        @SerializedName("name")
        val name : String,

        @SerializedName("description")
        val description : String,

        @SerializedName("type")
        val type : String,
)