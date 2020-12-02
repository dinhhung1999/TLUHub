package com.example.tlu_hub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tlu_hub.R
import com.example.tlu_hub.model.PopularModel

class PopularAdapter : RecyclerView.Adapter<PopularHolder> {
    private lateinit var populars: ArrayList<PopularModel>

    constructor(populars: ArrayList<PopularModel>) : super() {
        this.populars = populars
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHolder {
        return PopularHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_reyclerview_popular,parent,false))
    }

    override fun onBindViewHolder(holder: PopularHolder, position: Int) {
        if (holder != null) {
            holder.tvPopular.text = populars[position].Title
            Glide
                    .with(holder.itemView)
                    .load(populars[position].UrlImage)
                    .centerCrop()
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.ic_round_error_outline_24)
                    .into(holder.imPopular)

        }
    }

    override fun getItemCount(): Int {
        return populars.size
    }
}


class PopularHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var tvPopular: TextView = itemView!!.findViewById(R.id.tvPopular)
    var imPopular: ImageView = itemView!!.findViewById(R.id.imPopular)
}