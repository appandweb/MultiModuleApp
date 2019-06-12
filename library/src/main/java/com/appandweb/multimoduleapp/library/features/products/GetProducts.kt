package com.appandweb.multimoduleapp.library.features.products

interface GetProducts {
    fun getProducts(listener: Listener)

    interface Listener {
        fun onSuccess(products: List<MMProduct>)
        fun onFailure(t: Throwable)
    }
}
