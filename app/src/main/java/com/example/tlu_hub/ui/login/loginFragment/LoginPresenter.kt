package com.example.tlu_hub.ui.login.loginFragment

class LoginPresenter(var loginView: LoginView?, val loginInteractor: LoginInteractor) :
        LoginInteractor.OnLoginFinishedListener {

    fun validateCredentials(username: String, password: String) {
        loginInteractor.login(username, password,this)
    }

    fun onDestroy() {
        loginView = null
    }

    override fun onUsernameError() {
        loginView?.apply {
            setUsernameError()
            hideProgress()
        }
    }

    override fun onPasswordError() {
        loginView?.apply {
            setPasswordError()
            hideProgress()
        }
    }

    override fun onSuccess() {
        loginView?.hideProgress()
        loginView?.navigateToHome()
    }
}