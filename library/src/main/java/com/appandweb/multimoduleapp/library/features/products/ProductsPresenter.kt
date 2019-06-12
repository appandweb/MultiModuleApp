package com.appandweb.multimoduleapp.library.features.products

import com.appandweb.multimoduleapp.library.common.Presenter

class ProductsPresenter(val getProducts: GetProducts) :
    Presenter<ProductsPresenter.View, ProductsPresenter.Navigator>() {

    override fun initialize() {
        view?.clearList()

        getProducts.getProducts(object : GetProducts.Listener {
            override fun onSuccess(products: List<MMProduct>) {
                products
                    .takeIf { it.isNotEmpty() }
                    ?.forEach { view?.addProduct(it) }
                    .also {
                        view?.notifyChangesToList()
                    }

                products.takeIf { it.isEmpty() }?.let {
                    view?.showEmptyCase()
                }
            }

            override fun onFailure(t: Throwable) {
                view?.showError(t.message ?: "Unknown error listing products")
            }
        })
    }

    interface View {
        fun clearList()
        fun addProduct(product: MMProduct)
        fun notifyChangesToList()
        fun showError(message: String)
        fun showEmptyCase()
    }

    interface Navigator {
        fun close()
    }
}