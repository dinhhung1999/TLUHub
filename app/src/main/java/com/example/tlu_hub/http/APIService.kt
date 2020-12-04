package com.example.tlu_hub.http

import com.example.tlu_hub.contraints.Contraints.Companion.GETSTUDENT
import com.example.tlu_hub.contraints.Contraints.Companion.LOGIN
import com.example.tlu_hub.model.student.Student
import com.example.tlu_hub.model.userData.UserData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*


interface APIService {
    @POST(LOGIN)
    fun login(@Body body: Map<String, String>): Call<UserData>

    @GET(GETSTUDENT)
    fun getStudent(@Query("code_student") code_student: String): Call<List<Student>>

}