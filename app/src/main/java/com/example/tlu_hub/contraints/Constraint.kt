package com.example.tlu_hub.contraints

import com.example.tlu_hub.model.userData.UserData

class Constraint {
    interface API_STATUS {
        companion object {
            const val SUCCESS = "success"
            const val ERROR = "error"

        }
    }
    companion object {
        var account: UserData? = null
        lateinit var username: String
    }

}