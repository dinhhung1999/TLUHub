package com.example.tlu_hub.ui.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.GravityCompat
import com.bumptech.glide.Glide
import com.example.tlu_hub.MainActivity
import com.example.tlu_hub.R
import com.example.tlu_hub.contraints.Contraints
import com.example.tlu_hub.model.category.posts
import com.example.tlu_hub.ui.discover.DiscoverFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_post.*
class PostFragment(var posts: posts) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivity.navigationPosition = R.layout.fragment_post
//        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
//            val child: Fragment = DiscoverFragment()
//            val transaction = childFragmentManager.beginTransaction()
//            transaction.replace(R.id.post_Fragment, child).commit()
//        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }



    companion object {
        fun newInstance(posts: posts) =
                PostFragment(posts)
                }



    fun initView(){
        Glide
            .with(this)
            .load(Contraints.BASE_URL +posts.images_posts.formats.medium?.url)
            .placeholder(R.drawable.loading)
            .error(R.drawable.ic_round_error_outline_24)
            .into(imPost)
        tvTitlePost.text = posts.title_posts
        tvContentPost.text = posts.content_posts
    }

}