package com.example.tlu_hub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tlu_hub.R
import com.example.tlu_hub.contraints.Contraints.Companion.BASE_URL
import com.example.tlu_hub.model.category.Category

class NewsAdapter : RecyclerView.Adapter<NewsHolder> {
    private  var news = ArrayList<Category>()

    constructor(news: ArrayList<Category>) : super() {
        this.news = news
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recylerview_activity,parent,false))
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.tvNews.text = news[0].posts[position].title_posts
        Glide
                .with(holder.itemView)
                .load(BASE_URL+news[0].posts[position].images_posts.formats.medium?.url)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_round_error_outline_24)
                .into(holder.imNews)
    }

    override fun getItemCount(): Int {
        return news[0].posts.size
    }
}


class NewsHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var tvNews: TextView = itemView!!.findViewById(R.id.tvNews)
    var imNews: ImageView = itemView!!.findViewById(R.id.imNews)
}