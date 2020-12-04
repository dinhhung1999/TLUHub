package com.example.tlu_hub.model.student.formats

import com.google.gson.annotations.SerializedName

data class type(
        @SerializedName("name")
        val name : String,
        @SerializedName("hash")
        val hash : String,
        @SerializedName("ext")
        val ext : String,
        @SerializedName("mime")
        val mime : String,
        @SerializedName("width")
        val width : Int,
        @SerializedName("height")
        val height : Int,
        @SerializedName("size")
        val size : Double,
        @SerializedName("url")
        val url : String,
        )
