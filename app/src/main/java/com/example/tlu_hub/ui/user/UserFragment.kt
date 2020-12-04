package com.example.tlu_hub.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tlu_hub.R
import com.example.tlu_hub.contraints.Constraint
import com.example.tlu_hub.contraints.Constraint.Companion.userData
import com.example.tlu_hub.contraints.Constraint.Companion.username
import kotlinx.android.synthetic.main.fragment_user.*


class UserFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    companion object {
        fun newInstance() =
            UserFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Glide
//                .with(this)
//                .load(userData.user.)
//                .centerCrop()
//                .placeholder(R.drawable.loading)
//                .error(R.drawable.ic_round_error_outline_24)
//                .into(holder.imActivity)
        tvUserName.text = getString(R.string.useName) + " " + userData.user.username
        tvEmail.text = getString(R.string.email) + " " + userData.user.email
        tvCode_user.text =  getString(R.string.code_user) + " " + userData.user.code_user
    }
}