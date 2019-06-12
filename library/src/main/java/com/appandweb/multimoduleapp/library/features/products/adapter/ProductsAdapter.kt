package com.appandweb.multimoduleapp.library.features.products.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appandweb.multimoduleapp.library.R
import com.appandweb.multimoduleapp.library.features.products.MMProduct

class ProductsAdapter : RecyclerView.Adapter<ProductViewHolder>() {
    val items: MutableList<MMProduct> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_product, parent, false)

        return ProductViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        items[position].let { product ->
            holder.tvTitle.text = product.name
            holder.tvPrice.text = "${product.price} €"
        }
    }

    fun add(product: MMProduct) {
        items.add(product)
    }

    fun clear() {
        items.clear()
    }
}
