package com.example.tlu_hub.ui.login.loginFragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.HandlerCompat.postDelayed
import androidx.databinding.DataBindingUtil
import com.example.tlu_hub.MainActivity
import com.example.tlu_hub.R
import kotlinx.android.synthetic.main.fragment_login.*


@Suppress("DEPRECATION")
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
        btnLogin.setOnClickListener {
            showProgress()
            postDelayed(2000) {
                hideProgress()
                navigateToHome()
            }
        }
    }


//    private fun validateCredentials(userName : String, password : String) {
////        presenter.validateCredentials(userName,password);
//    }

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
        startActivity(Intent(context, MainActivity::class.java))

    }
    private fun postDelayed(delayMillis: Long, task: () -> Unit) {
        Handler().postDelayed(task, delayMillis)
    }

}