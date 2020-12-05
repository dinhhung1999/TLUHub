package com.example.tlu_hub.model.Post
import com.example.tlu_hub.model.student.formats.formats
import com.google.gson.annotations.SerializedName

data class imagePost(
        @SerializedName("id")
        val id : Int,
        @SerializedName("name")
        val name : String,
        @SerializedName("alternativeText")
        val alternativeText : String,
        @SerializedName("caption")
        val caption : String,
        @SerializedName("width")
        val width : Int,
        @SerializedName("height")
        val height : Int,
        @SerializedName("formats")
        val formats : formats,
        @SerializedName("ext")
        val ext : String,
        @SerializedName("hash")
        val hash : String,
        @SerializedName("mime")
        val mime : String,
        @SerializedName("size")
        val size : Double,
        @SerializedName("url")
        val url : String,
        @SerializedName("previewUrl")
        val previewUrl : String,
        @SerializedName("provider")
        val provider : String,
        @SerializedName("provider_metadata")
        val provider_metadata : String,
        @SerializedName("created_at")
        val created_at : String,
        @SerializedName("updated_at")
        val updated_at : String,
        )