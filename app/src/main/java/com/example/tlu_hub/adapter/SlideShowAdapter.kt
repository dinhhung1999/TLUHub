package com.example.tlu_hub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.tlu_hub.R
import com.example.tlu_hub.contraints.Contraints
import com.example.tlu_hub.contraints.Contraints.Companion.BASE_URL
import com.example.tlu_hub.model.category.Category
import com.smarteist.autoimageslider.SliderViewAdapter
import java.util.*

class SlideShowAdapter : SliderViewAdapter<SlideShowAdapter.SliderAdapterHolder> {
    private var SliderItems = ArrayList<Category>()
    constructor(SliderItems: ArrayList<Category>) : super() {
        this.SliderItems = SliderItems
    }

    override fun getCount(): Int {
        return SliderItems[0].posts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterHolder {
        val inflate = LayoutInflater.from(parent!!.context).inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterHolder, position: Int) {
        if(viewHolder!=null){
            viewHolder.tv_title_slider.text = SliderItems[0].posts[position]?.title_posts
            Glide
                    .with(viewHolder.itemView)
                    .load(BASE_URL +SliderItems[0].posts[position].images_posts.formats.medium?.url)
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.ic_round_error_outline_24)
                    .into(viewHolder.iv_image_slider)
        }

    }
    class SliderAdapterHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView!!) {
        var tv_title_slider: TextView = itemView!!.findViewById(R.id.tv_title_slider)
        var iv_image_slider: ImageView = itemView!!.findViewById(R.id.iv_image_slider)
    }
}