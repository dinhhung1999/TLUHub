package com.example.tlu_hub.ui.login.spashScreen

class SplashPresenter(var splashView: SplashView?, val splashInteractor: SplashInteractor) :
    SplashInteractor.OnCickFinishedListener{


    fun onDestroy() {
    splashView = null
    }

    override fun onSuccess() {
        splashView?.navigateToLogin()
    }

}