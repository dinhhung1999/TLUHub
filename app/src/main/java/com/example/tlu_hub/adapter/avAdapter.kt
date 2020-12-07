package com.example.tlu_hub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tlu_hub.R
import com.example.tlu_hub.contraints.Contraints
import com.example.tlu_hub.model.category.Category
import com.example.tlu_hub.model.category.posts


class avAdapter : RecyclerView.Adapter<atHD> {
    private  var news = ArrayList<Category>()

    constructor(news: ArrayList<Category>) : super() {
        this.news = news
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): atHD {
        return atHD(LayoutInflater.from(parent.context).inflate(R.layout.item_activity,parent,false))
    }

    override fun onBindViewHolder(holder: atHD, position: Int) {
        holder.tvtt.text = news[0].posts[position].title_posts
        Glide
                .with(holder.itemView)
                .load(Contraints.BASE_URL +news[0].posts[position].images_posts.formats.medium?.url)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_round_error_outline_24)
                .into(holder.imavt)

    }

    override fun getItemCount(): Int {
        return news[0].posts.size
    }
}


class atHD(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var tvtt: TextView = itemView!!.findViewById(R.id.tvhd)
    var imavt: ImageView = itemView!!.findViewById(R.id.imavt)
}