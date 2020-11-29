package com.example.tlu_hub.ui.login.loginFragment

interface LoginView {
    fun showProgress()
    fun hideProgress()
    fun setUsernameError()
    fun setPasswordError()
    fun navigateToHome()
}