package com.appandweb.multimoduleapp.library.features.events.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.appandweb.multimoduleapp.library.R

class EventViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var tvTitle: TextView = v.findViewById(R.id.tvTitle)
    var tvPrice: TextView = v.findViewById(R.id.tvPrice)
}
