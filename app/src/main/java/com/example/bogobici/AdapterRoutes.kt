package com.example.bogobici

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterRoutes(private var routes: List<RoutesData>) : RecyclerView.Adapter<AdapterRoutes.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemName: TextView
        val imagesRecyclerView: RecyclerView = itemView.findViewById(R.id.rv_zipaquira)

        init {
            itemName = itemView.findViewById(R.id.textRoute)
        }

        fun bind(item: RoutesData) {
            itemName.text = item.name
            imagesRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            imagesRecyclerView.adapter = AdapterCarousel(item.images)
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
        holder.bind(routes[position])
    }

    override fun getItemCount() = routes.size

    fun setRoutes(newRoutes: List<RoutesData>) {
        routes = newRoutes
        notifyDataSetChanged()
    }

}