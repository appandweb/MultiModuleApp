package com.appandweb.multimoduleapp.library.features.products.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.appandweb.multimoduleapp.library.R

class ProductViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var tvTitle: TextView = v.findViewById(R.id.tvTitle)
    var tvPrice: TextView = v.findViewById(R.id.tvPrice)
}
