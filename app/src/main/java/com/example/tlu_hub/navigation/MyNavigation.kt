package com.example.tlu_hub.navigation

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tlu_hub.MainActivity
import com.example.tlu_hub.R

class MyNavigation {

    companion object {
        private var instance: MyNavigation? = null
        private var navController: NavController? = null

        fun getInstance(): MyNavigation {
            if (instance == null) {
                instance = MyNavigation()
//                throw IllegalAccessException("Preferences must be initialized in Application class first.")
            }
            return instance as MyNavigation
        }

        fun init(activity: Activity) {
            navController = Navigation.findNavController(
                    activity,
                    R.id.container
            )
            instance = MyNavigation()
        }
    }

//    fun goToLogin(contextFrom: Context) {
//        val intent = Intent(contextFrom, vn.dms.sharkforsale.general.login.LoginActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        contextFrom.startActivity(intent)
//    }

    fun goToMain(contextFrom: Context) {
        val intent = Intent(contextFrom, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        contextFrom.startActivity(intent)
    }
}