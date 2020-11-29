package com.example.tlu_hub.ui.login

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tlu_hub.R
import com.example.tlu_hub.ui.login.spashScreen.SplashFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getFragment(SplashFragment())

    }
    private fun getFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerLogin, fragment)
                .commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}