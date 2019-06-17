package com.appandweb.multimoduleapp.library.features.events

data class MMGroup(
    val uid: String,
    val name: String,
    val participants: MutableList<MMUser>
)
