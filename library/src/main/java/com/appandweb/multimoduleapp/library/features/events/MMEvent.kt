package com.appandweb.multimoduleapp.library.features.events

data class MMEvent(
    val uid: String,
    val name: String,
    val thumbnail: String,
    val price: Float = 0.toFloat()
)