package com.appandweb.multimoduleapp.library.features.events

import com.appandweb.multimoduleapp.library.common.Presenter

class EventsPresenter(val getEvents: GetEvents) :
    Presenter<EventsPresenter.View, EventsPresenter.Navigator>() {

    override fun initialize() {
        view?.clearList()

        getEvents.getEvents(object : GetEvents.Listener {
            override fun onSuccess(events: List<MMEvent>) {
                events
                    .takeIf { it.isNotEmpty() }
                    ?.forEach { view?.addEvent(it) }
                    .also {
                        view?.notifyChangesToList()
                    }

                events.takeIf { it.isEmpty() }?.let {
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
        fun addEvent(event: MMEvent)
        fun notifyChangesToList()
        fun showError(message: String)
        fun showEmptyCase()
    }

    interface Navigator {
        fun close()
    }
}