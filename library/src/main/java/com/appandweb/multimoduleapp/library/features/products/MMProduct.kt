package com.appandweb.multimoduleapp.library.features.products

data class MMProduct(
    val uid: String,
    val name: String,
    val thumbnail: String,
    val price: Float = 0.toFloat()
)