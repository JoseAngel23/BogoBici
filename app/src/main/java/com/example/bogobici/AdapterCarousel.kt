package com.example.bogobici

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class AdapterCarousel(private var imagesCarousel: List<CarouselData>) : RecyclerView.Adapter<AdapterCarousel.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImg: ImageView

        init {
            itemImg = itemView.findViewById(R.id.img_route)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.route_item, viewGroup, false) // Usando un layout simple
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val images = imagesCarousel[position]
        Glide.with(holder.itemImg.context).load(images.images).into(holder.itemImg)
    }

    override fun getItemCount() = imagesCarousel.size

    fun setImages(newImages: List<CarouselData>) {
        imagesCarousel = newImages
        notifyDataSetChanged()
    }

}