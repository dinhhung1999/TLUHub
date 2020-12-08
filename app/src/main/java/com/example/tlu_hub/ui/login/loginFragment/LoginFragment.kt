package com.example.tlu_hub.ui.login.loginFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tlu_hub.navigation.MyNavigation
import com.example.tlu_hub.R
import kotlinx.android.synthetic.main.fragment_login.*

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

class LoginFragment : Fragment(),LoginView {
    private val presenter = LoginPresenter(this, LoginInteractor())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_login, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        etUser.setText("hungdv@wru.vn")
//        etPassword.setText("123456")
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
        etPassword.error = "Mật khẩu không chính xác"
    }

    override fun setPasswordError() {
        etPassword.error = "Mật khẩu không chính xác"
    }

    override fun navigateToHome() {
        context?.let { MyNavigation.getInstance().goToMain(it) }

    }
}

