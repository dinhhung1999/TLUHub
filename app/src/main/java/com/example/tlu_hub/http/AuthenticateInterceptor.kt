package com.example.tlu_hub.http

import android.text.TextUtils
import com.example.tlu_hub.contraints.Constraint
import com.example.tlu_hub.contraints.Constraint.API_STATUS.Companion.isLogin
import com.example.tlu_hub.data_local.Preferences
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticateInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.headers().newBuilder()
//        builder.add("Accept", "application/json")
//        builder.add("Content-Type", "application/json")
        val authentication = Preferences.getInstance().getToken()

        if (isLogin) {
            builder.add("Authorization", "Bearer $authentication")
        }
//        if (!TextUtils.isEmpty(Preferences.getInstance().getToken())) {
//            builder.add("Authorization", "Bearer ${Preferences.getInstance().getToken()}")
//        }
        val headers = builder.build()
        val newRequest = request.newBuilder().headers(headers).build()
        val response = chain.proceed(newRequest)
//        val res = response.peekBody(Long.MAX_VALUE)
        return response
    }
}