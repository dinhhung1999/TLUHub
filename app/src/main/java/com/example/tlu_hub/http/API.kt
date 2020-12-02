package com.example.tlu_hub.http

import com.example.tlu_hub.BuildConfig.BASE_URL

object API {
    val apiService: APIService = RetrofitClient.getRetrofitClient(BASE_URL).create(APIService::class.java)
}