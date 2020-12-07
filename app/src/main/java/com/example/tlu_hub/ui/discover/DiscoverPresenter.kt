package com.example.tlu_hub.ui.discover

import android.util.Log
import com.example.tlu_hub.contraints.Constraint
import com.example.tlu_hub.contraints.Constraint.Companion.new
import com.example.tlu_hub.data_local.Preferences
import com.example.tlu_hub.http.API
import com.example.tlu_hub.model.category.Category
import com.example.tlu_hub.model.student.Student
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverPresenter(var view: DiscoverView?) {
    val slideShows = ArrayList<Category>()
    val news = ArrayList<Category>()

    fun getSlide(){
        val call: Call<List<Category>> = API.apiService.getCategory("SlideShow")
        call.enqueue(object : Callback<List<Category>>{

            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                slideShows.clear()
                slideShows.addAll(response.body()!!)
                view?.onSetUpSlide()
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    fun getNews(){
        val call: Call<List<Category>> = API.apiService.getCategory("News")
        call.enqueue(object : Callback<List<Category>>{

            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if (response.isSuccessful) {
                    news.clear()
                    news.addAll(response.body()!!)
                    new.addAll(response.body()!!)
                    view?.onSetUpNews()
                } else {
                    when (response.code()) {
                        400 -> Log.e("Error 400", "Bad Request")
                        404 -> Log.e("Error 404", "Not Found")
                        else -> Log.e("Error", "Generic Error")
                    }
                }

            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}