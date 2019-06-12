package com.appandweb.multimoduleapp.library.features.products

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class ProductsActivity : AppCompatActivity(), ProductsPresenter.View, ProductsPresenter.Navigator {

    override fun clearList() {
        // adapter?.clear()
    }

    override fun addProduct(product: MMProduct) {
        // adapter?.add(product)
    }

    override fun notifyChangesToList() {
        // adapter?.notifyDatasetChanged()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, LENGTH_SHORT).show()
    }

    override fun showEmptyCase() {
        // tvEmptyCase.visibility = VISIBLE
    }

    override fun close() = finish()
}
