package com.example.tlu_hub.model.student.formats

import com.google.gson.annotations.SerializedName

data class formats(
        @SerializedName("thumbnail")
        val thumbnail : type,

        @SerializedName("medium")
        val medium : type,

        @SerializedName("small")
        val small : type,


)
