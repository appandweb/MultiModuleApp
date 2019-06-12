package com.appandweb.multimoduleapp.library.features.products

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.appandweb.multimoduleapp.library.R
import com.appandweb.multimoduleapp.library.features.products.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity(), ProductsPresenter.View, ProductsPresenter.Navigator {

    var adapter: ProductsAdapter? = null
    lateinit var presenter: ProductsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_products)

        adapter = ProductsAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)

        presenter = ProductsPresenter(GetProductsMockImpl())
        presenter.view = this
        presenter.navigator = this

        presenter.initialize()
    }

    override fun clearList() {
        adapter?.clear()
    }

    override fun addProduct(product: MMProduct) {
        adapter?.add(product)
    }

    override fun notifyChangesToList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, LENGTH_SHORT).show()
    }

    override fun showEmptyCase() {
        tvEmptyCase.visibility = VISIBLE
    }

    override fun close() = finish()
}
