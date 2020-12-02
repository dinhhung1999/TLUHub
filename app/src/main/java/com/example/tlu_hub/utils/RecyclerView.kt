package com.example.tlu_hub.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setOnLoadMore(listener: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (layoutManager is LinearLayoutManager && (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() + 1 == adapter?.itemCount) {
                listener()
            } else if (layoutManager is GridLayoutManager && (layoutManager as GridLayoutManager).findLastCompletelyVisibleItemPosition() + 1 == adapter?.itemCount) {
                listener()
            }
        }
    })
}