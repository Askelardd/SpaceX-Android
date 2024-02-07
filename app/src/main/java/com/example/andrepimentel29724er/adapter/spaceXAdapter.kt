package com.example.andrepimentel29724er.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.andrepimentel29724er.R
import com.example.andrepimentel29724er.model.Crew


class SpaceXAdapter(private var spaceX: List<Crew>) : RecyclerView.Adapter<SpaceXAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_crew, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spacex = spaceX[position]

        holder.crewName.text = spacex.name

        Glide.with(holder.itemView)
            .load(spacex.image)
            .into(holder.crewFoto)
    }

    override fun getItemCount(): Int {
        return spaceX.size
    }

    fun updateCrew(newCrew: List<Crew>) {
        spaceX = newCrew
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val crewName: TextView = itemView.findViewById(R.id.txtcrewName)
        val crewFoto: ImageView = itemView.findViewById(R.id.imgspaceX)
    }
}