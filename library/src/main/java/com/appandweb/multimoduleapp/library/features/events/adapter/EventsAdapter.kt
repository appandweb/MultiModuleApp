package com.appandweb.multimoduleapp.library.features.events.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appandweb.multimoduleapp.library.R
import com.appandweb.multimoduleapp.library.features.events.MMEvent

class EventsAdapter : RecyclerView.Adapter<EventViewHolder>() {
    val items: MutableList<MMEvent> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_event, parent, false)

        return EventViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        items[position].let { product ->
            holder.tvTitle.text = product.name
            holder.tvPrice.text = "${product.price} €"
        }
    }

    fun add(event: MMEvent) {
        items.add(event)
    }

    fun clear() {
        items.clear()
    }
}
