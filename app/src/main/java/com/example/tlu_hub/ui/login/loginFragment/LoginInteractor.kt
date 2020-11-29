package com.example.tlu_hub.ui.login.loginFragment

import androidx.core.os.HandlerCompat.postDelayed

class LoginInteractor {

    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onSuccess()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener) {

//                username.isEmpty() -> listener.onUsernameError()
//                password.isEmpty() -> listener.onPasswordError()
         listener.onSuccess()
    }
}