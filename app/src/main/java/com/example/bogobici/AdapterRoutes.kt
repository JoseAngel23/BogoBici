package com.example.bogobici

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRoutes(private var routes: List<RoutesData>) : RecyclerView.Adapter<AdapterRoutes.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemName: TextView

        init {
            itemName = itemView.findViewById(R.id.textRoute)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.upcoming_route_four, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val route = routes[position]
        holder.itemName.text = route.name
    }

    override fun getItemCount() = routes.size

    fun setRoutes(newRoutes: List<RoutesData>) {
        routes = newRoutes
        notifyDataSetChanged()
    }

}