package com.txcsmad.mad.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.txcsmad.mad.R
import com.txcsmad.mad.models.Event
import kotlinx.android.synthetic.main.item_event.view.*

class EventAdapter(private val events: List<Event>) : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val eventView = layoutInflater.inflate(R.layout.item_event, parent)
        return EventHolder(eventView)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bindData(events[position])
    }

    class EventHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(event: Event) {
            Picasso.with(itemView.context).load(event.imageUrl).into(itemView.image_event_icon)
            itemView.text_title.text = event.title
            itemView.text_time.text = event.timeSpan
            itemView.text_location.text = event.location
        }
    }
}