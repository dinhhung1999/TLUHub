package com.example.tlu_hub.ui.user

import com.example.tlu_hub.contraints.Constraint.Companion.userData

class UserPresenter(var userView: UserView?) {
    fun setView(){
       userView?.onSuccess()
    }
}