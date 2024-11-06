package com.example.bogobici

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class AdapterNotification (private var notifications: List<NotificationData>) : RecyclerView.Adapter<AdapterNotification.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImg: ImageView
        var itemDescription: TextView

        init {
            itemImg = itemView.findViewById(R.id.imageViewNotification)
            itemDescription = itemView.findViewById(R.id.textNotification)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AdapterNotification.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.notification_item, viewGroup, false)
        return AdapterNotification.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterNotification.ViewHolder, position: Int) {
        val notification = notifications[position]
        Glide.with(holder.itemImg.context).load(notification.icon).transform(CircleCrop()).into(holder.itemImg)
        holder.itemDescription.text = notification.description
    }

    override fun getItemCount() = notifications.size

    fun setNotification(newNotification: List<NotificationData>) {
        notifications = newNotification
        notifyDataSetChanged()
    }
}