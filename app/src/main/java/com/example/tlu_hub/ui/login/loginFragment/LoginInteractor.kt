package com.example.tlu_hub.ui.login.loginFragment

import java.util.*

class LoginInteractor {
    private lateinit var body: HashMap<String, String>

    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener) {
        if (username.isEmpty() || password.isEmpty()) {
            listener.onUsernameError()
            return
        }
        body = hashMapOf(
            "identifier" to username,
            "password" to password
        )
//        val call: Call<UserData> = API.apiService.login(body)
//        call.enqueue(object : Callback<UserData> {
//            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
//                if (response.isSuccessful) {
//                    Preferences.getInstance().saveToken(response.body()!!.token)
//                    Constraint.username = response.body()?.user!!.username
//                    listener.onSuccess()
//                } else {
//                    when (response.code()) {
//                        400 -> Log.e("Error 400", "Bad Request")
//                        404 -> Log.e("Error 404", "Not Found")
//                        else -> Log.e("Error", "Generic Error")
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<UserData>, t: Throwable) {
//                Log.e("ERROR: ", t.message!!)
//            }
//
//            /**
//             * Invoked for a received HTTP response.
//             *
//             *
//             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
//             * Call [Response.isSuccessful] to determine if the response indicates success.
//             */
//
//        })
//
//
//    }
    }
}