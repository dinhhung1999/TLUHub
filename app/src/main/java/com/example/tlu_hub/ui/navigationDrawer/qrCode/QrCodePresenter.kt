package com.example.tlu_hub.ui.navigationDrawer.qrCode

import android.util.Log
import com.example.tlu_hub.http.API
import com.example.tlu_hub.model.student.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QrCodePresenter(var qrCodeView: QrCodeView?) {
    val students = ArrayList<Student>()
    fun getStudent(codeStudent : String) {
        qrCodeView?.showProgress()
        val call: Call<List<Student>> = API.apiService.getStudent(codeStudent)
        call.enqueue(object : Callback<List<Student>>{
            override fun onResponse(call: Call<List<Student>>, response: Response<List<Student>>) {
                qrCodeView?.hideProgress()
                if (response.isSuccessful) {
                    students.clear()
                    students.addAll(response.body()!!)
                    qrCodeView?.onSuccess()
                } else {
                    when (response.code()) {
                        400 -> Log.e("Error 400", "Bad Request")
                        404 -> Log.e("Error 404", "Not Found")
                        else -> Log.e("Error", "Generic Error")
                    }
                }
            }
            override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                qrCodeView?.hideProgress()
                Log.e("ERROR: ", t.message!!)
            }

        })


    }
    fun Destroy(){
        qrCodeView = null
    }

}