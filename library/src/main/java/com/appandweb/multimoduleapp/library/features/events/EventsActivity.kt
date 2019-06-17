package com.appandweb.multimoduleapp.library.features.events

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.appandweb.multimoduleapp.library.R
import com.appandweb.multimoduleapp.library.features.events.adapter.EventsAdapter
import kotlinx.android.synthetic.main.activity_events.*

class EventsActivity : AppCompatActivity(), EventsPresenter.View, EventsPresenter.Navigator {

    var adapter: EventsAdapter? = null
    lateinit var presenter: EventsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_events)

        adapter = EventsAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, VERTICAL, false)

        presenter = EventsPresenter(GetEventsMockImpl())
        presenter.view = this
        presenter.navigator = this

        presenter.initialize()
    }

    override fun clearList() {
        adapter?.clear()
    }

    override fun addEvent(event: MMEvent) {
        adapter?.add(event)
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
