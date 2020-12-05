package com.example.tlu_hub.ui.navigationDrawer.qrCode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tlu_hub.R
import com.example.tlu_hub.contraints.Contraints.Companion.BASE_URL
import kotlinx.android.synthetic.main.fragment_qr_code.*
import kotlinx.android.synthetic.main.fragment_user.*
import java.net.URL


class QrCodeFragment(var codeStudent: String) : Fragment() , QrCodeView{
    private val presenter = QrCodePresenter(this )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter.getStudent(codeStudent)
        return inflater.inflate(R.layout.fragment_qr_code, container, false)
    }

    companion object {
        fun newInstance(codeStudent : String) =
                QrCodeFragment(codeStudent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun showProgress() {
        progress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress?.visibility = View.GONE
    }

    override fun onSuccess() {
        Glide
                .with(this)
                .load(BASE_URL+presenter.students[0].avatar_student.formats.medium.url)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_round_error_outline_24)
                .into(imAvatarStudent)
        tvName?.text = presenter.students[0].name_student
        tvCodeStudent?.text = presenter.students[0].code_student
        tvBirthDay?.text = presenter.students[0].birthday_student
        tvHometown?.text = presenter.students[0].hometown_student
        tvGender?.text = presenter.students[0].gender_student
        tvCourse?.text = presenter.students[0].course.code_course
        tvClass?.text = presenter.students[0].Class.code_class
        tvFaculty?.text = presenter.students[0].faculty.name_faculty
        tvMajor?.text = presenter.students[0].major.name_majors
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        presenter.Destroy()
        super.onDestroy()
    }
}