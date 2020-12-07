package com.example.tlu_hub.adapter

import com.example.tlu_hub.model.category.Category

interface iPostClickListener {
    fun PostClickListener(post : Category, position : Int)
}