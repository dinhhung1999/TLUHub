package com.example.tlu_hub.ui.login.spashScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tlu_hub.R
import com.example.tlu_hub.databinding.FragmentSplashBinding
import com.example.tlu_hub.ui.login.loginFragment.LoginFragment

class SplashFragment : Fragment(), SplashView {

    private val presenter = SplashPresenter(this, SplashInteractor())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentSplashBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_splash,
            container,
            false
        )

        binding.btnStart.setOnClickListener{

            binding.clSplash.visibility = View.GONE
            toLogin()
        }

        return binding.root
    }

    private fun toLogin() {
        presenter.onSuccess()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun navigateToLogin() {
        val child: Fragment = LoginFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.child_Fragment, child).commit()
    }
}

