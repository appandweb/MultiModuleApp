package com.appandweb.multimoduleapp.library.features.events

interface GetEvents {
    fun getEvents(listener: Listener)

    interface Listener {
        fun onSuccess(events: List<MMEvent>)
        fun onFailure(t: Throwable)
    }
}
