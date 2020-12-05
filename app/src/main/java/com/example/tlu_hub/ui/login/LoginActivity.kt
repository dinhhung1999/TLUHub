package com.example.tlu_hub.ui.login

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tlu_hub.R
import com.example.tlu_hub.data_local.Preferences
import com.example.tlu_hub.ui.login.spashScreen.SplashFragment
import pub.devrel.easypermissions.EasyPermissions

class LoginActivity : AppCompatActivity() {
    val LOGINACTIVITY = 1999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Preferences.init(this)
        getFragment(SplashFragment())
        if (!checkRequiredPermissions()) checkRequiredPermissions()
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

    private fun checkRequiredPermissions(): Boolean {
        val perms = arrayOf(
                Manifest.permission.CHANGE_CONFIGURATION,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.CHANGE_NETWORK_STATE,
                Manifest.permission.ACCESS_NETWORK_STATE,
        )
        if (!EasyPermissions.hasPermissions(this, *perms)) {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.message_request_permission_read_phone_state), LOGINACTIVITY, *perms)
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }
}