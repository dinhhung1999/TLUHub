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


class ActivityAdapter : RecyclerView.Adapter<ActivityHolder> {
    private lateinit var populars: ArrayList<PopularModel>

    constructor(populars: ArrayList<PopularModel>) : super() {
        this.populars = populars
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityHolder {
        return ActivityHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recylerview_activity,parent,false))
    }

    override fun onBindViewHolder(holder: ActivityHolder, position: Int) {
        if (holder != null) {
            holder.tvActivity.text = populars[position].Title
            Glide
                .with(holder.itemView)
                .load(populars[position].UrlImage)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_round_error_outline_24)
                .into(holder.imActivity)

        }
    }

    override fun getItemCount(): Int {
        return populars.size
    }

}
class ActivityHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var tvActivity: TextView = itemView!!.findViewById(R.id.tvActivity)
    var imActivity: ImageView = itemView!!.findViewById(R.id.imActivity)
}


