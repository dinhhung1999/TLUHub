package com.example.tlu_hub

import android.util.Log
import com.example.tlu_hub.contraints.Constraint

import com.example.tlu_hub.contraints.Constraint.Companion.userData
import com.example.tlu_hub.data_local.Preferences
import com.example.tlu_hub.http.API
import com.example.tlu_hub.model.student.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val mainView: MainView?) {
    fun getUserData(codeUser : String){
        val call: Call<List<Student>> = API.apiService.getStudent(codeUser)
        call.enqueue(object : Callback<List<Student>> {
            override fun onResponse(call: Call<List<Student>>, response: Response<List<Student>>) {
                if (response.isSuccessful) {
                    userData.clear()
                    userData.addAll(response.body()!!)
                    mainView?.onSetProfile()
                } else {
                    when (response.code()) {
                        400 -> Log.e("Error 400", "Bad Request")
                        404 -> Log.e("Error 404", "Not Found")
                        else -> Log.e("Error", "Generic Error")
                    }
                }
            }
            override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
            }
        })

    }
}