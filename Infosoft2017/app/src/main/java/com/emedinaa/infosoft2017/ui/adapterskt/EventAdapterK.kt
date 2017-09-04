package com.emedinaa.infosoft2017.ui.adapterskt

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.emedinaa.infosoft2017.R
import com.emedinaa.infosoft2017.model.EntityK
import kotlinx.android.synthetic.main.row_speaker.view.*

/**
 * Created by emedinaa on 3/09/17.
 */
class EventAdapterK(val events:List<EntityK.EventK>, val context: Context): RecyclerView.Adapter<EventAdapterK.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.textViewName
        val textViewBio: TextView = view.textViewBio
        val imageViewContact: ImageView = view.imageViewContact
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.row_speaker, parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val time: String = events[position].time!!
        val activity: String? = events[position].activity

        holder.textViewName.text = time
        holder.textViewBio.text = activity
    }

    override fun getItemCount(): Int {
        return events.size
    }
}