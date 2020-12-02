package com.example.tlu_hub.http

import com.example.tlu_hub.contraints.Contraints.Companion.LOGIN
import com.example.tlu_hub.model.userData.UserData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface APIService {
    @POST(LOGIN)
    fun login(@Body body: Map<String, String>): Call<UserData>

}