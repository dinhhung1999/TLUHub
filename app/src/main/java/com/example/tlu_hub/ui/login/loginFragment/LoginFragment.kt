package com.example.tlu_hub.ui.login.loginFragment

import android.Manifest
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tlu_hub.navigation.MyNavigation
import com.example.tlu_hub.R
import kotlinx.android.synthetic.main.fragment_login.*
import pub.devrel.easypermissions.EasyPermissions

/**
 * //                       _ooOoo_
 * //                      o8888888o
 * //                      88" . "88
 * //                      (| -_- |)
 * //                       O\ = /O
 * //                   ____/`---'\____
 * //                 .   ' \\| |// `.
 * //                  / \\||| : |||// \
 * //                / _||||| -:- |||||- \
 * //                  | | \\\ - /// | |
 * //                | \_| ''\---/'' | |
 * //                 \ .-\__ `-` ___/-. /
 * //              ______`. .' /--.--\ `. . __
 * //           ."" '< `.___\_<|>_/___.' >'"".
 * //          | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //            \ \ `-. \_ __\ /__ _/ .-` / /
 * //    ======`-.____`-.___\_____/___.-`____.-'======
 * //                       `=---='
 * //
 * //    .............................................
 * //                    Pray for no Bugs
 * =====================================================
 * Name：DVHung
 * Create on：25-11-2020
 * =====================================================
 */

@Suppress("DEPRECATION")
class LoginFragment : Fragment(),LoginView {
    val LOGINACTIVITY = 1999
    private val presenter = LoginPresenter(this, LoginInteractor())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_login, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener {
            validateCredentials()

        }
    }


    private fun validateCredentials() {
        presenter.validateCredentials(etUser.text.toString(), etPassword.text.toString())

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun setUsernameError() {
        TODO("Not yet implemented")
    }

    override fun setPasswordError() {
        TODO("Not yet implemented")
    }

    override fun navigateToHome() {
        context?.let { MyNavigation.getInstance().goToMain(it) }

    }
    private fun postDelayed(delayMillis: Long, task: () -> Unit) {
        Handler().postDelayed(task, delayMillis)
    }

    fun checkRequiredPermissions(): Boolean {
        val perms = arrayOf(
//            Manifest.permission.CHANGE_CONFIGURATION,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CHANGE_NETWORK_STATE,
            Manifest.permission.ACCESS_NETWORK_STATE,
//            Manifest.permission.LOCATION_HARDWARE,
//            Manifest.permission.ACCESS_COARSE_LOCATION,
//            Manifest.permission.ACCESS_FINE_LOCATION,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (!context?.let { EasyPermissions.hasPermissions(it, *perms) }!!) {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(
                this,
                "",
                LOGINACTIVITY,
                *perms
            )
            return false
        }
        return true
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}

