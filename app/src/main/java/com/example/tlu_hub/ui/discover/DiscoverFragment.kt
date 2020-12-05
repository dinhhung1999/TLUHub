package com.example.tlu_hub.ui.discover

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tlu_hub.R
import com.example.tlu_hub.adapter.NewsAdapter
import com.example.tlu_hub.adapter.PopularAdapter
import com.example.tlu_hub.adapter.SlideShowAdapter
import com.example.tlu_hub.model.PopularModel
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_discover.*


class DiscoverFragment : Fragment(),DiscoverView {

    var populars : ArrayList<PopularModel> =  ArrayList<PopularModel>()
    private var presenter = DiscoverPresenter(this)

    companion object {
        fun newInstance() =
            DiscoverFragment()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        presenter.getSlide()
        presenter.getNews()
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populars.add(
                PopularModel(
                        1,
                        "Đảm bảo chất lượng",
                        "http://www.tlu.edu.vn/portals/0/images/front/quality.jpg"
                )
        )
        populars.add(
                PopularModel(
                        1,
                        "Tạp chí",
                        "http://www.tlu.edu.vn/portals/0/images/front/www.jpg"
                )
        )
        populars.add(
                PopularModel(
                        1,
                        "Thư viện",
                        "http://www.tlu.edu.vn/portals/0/images/front/library.jpg"
                )
        )
        populars.add(
                PopularModel(
                        1,
                        "TLU Mail",
                        "http://www.tlu.edu.vn/portals/0/images/front/email.jpg"
                )
        )
        populars.add(
                PopularModel(
                        1,
                        "Lịch công tác",
                        "http://www.tlu.edu.vn/portals/0/images/front/lichcongtac.jpg"
                )
        )
        populars.add(
                PopularModel(
                        1,
                        "Đăng ký học",
                        "http://www.tlu.edu.vn/portals/0/images/front/user.jpg"
                )
        )


        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(
                context, RecyclerView.HORIZONTAL, false
        )

        rvPopular.layoutManager = layoutManager
        rvPopular.setHasFixedSize(true)
        rvPopular.itemAnimator = DefaultItemAnimator()
        rvPopular.addItemDecoration(
                DividerItemDecoration(
                        rvPopular.context,
                        DividerItemDecoration.VERTICAL
                )
        )
        rvPopular.adapter = PopularAdapter(populars)



    }

    override fun onSetUpSlide() {
        var sliderImageAdapter = SlideShowAdapter(presenter.slideShows)
        imageSilde.setSliderAdapter(sliderImageAdapter)
        imageSilde.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM) //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        imageSilde.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        imageSilde.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageSilde.indicatorSelectedColor = Color.WHITE
        imageSilde.indicatorUnselectedColor = Color.GRAY
        imageSilde.setIndicatorMarginCustom(0, 20, 0, 550)
        imageSilde.scrollTimeInSec = 4
        imageSilde.isAutoCycle = true
        imageSilde.startAutoCycle()

    }

    override fun onSetUpNews() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(
                context, RecyclerView.VERTICAL, false
        )
        rvActivity.layoutManager = layoutManager
        rvActivity.setHasFixedSize(true)
        rvActivity.itemAnimator = DefaultItemAnimator()
        rvActivity.addItemDecoration(
                DividerItemDecoration(
                        rvPopular.context,
                        DividerItemDecoration.VERTICAL
                )
        )
//        rvPopular.adapter = populars?.let { PopularAdapter(it) }
        rvActivity.adapter = NewsAdapter(presenter.news)
    }
}