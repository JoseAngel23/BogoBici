package com.example.bogobici

import android.annotation.SuppressLint
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.example.bogobici.databinding.CommentsItemBinding
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class AdapterComments(private var comments: List<CommentsData>) : RecyclerView.Adapter<AdapterComments.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImg: ImageView
        var itemName: TextView
        var itemDescription: TextView
        var itemValoration: RatingBar
        var itemDate: TextView

        init {
            itemImg = itemView.findViewById(R.id.imageView3)
            itemName = itemView.findViewById(R.id.textView5)
            itemDescription = itemView.findViewById(R.id.textView6)
            itemValoration = itemView.findViewById(R.id.ratingBar2)
            itemDate = itemView.findViewById(R.id.textView7)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.comments_item, viewGroup, false) // Usando un layout simple
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = comments[position]
        holder.itemName.text = comment.name
        Glide.with(holder.itemImg.context).load(comment.urlImage).transform(CircleCrop()).into(holder.itemImg)
        holder.itemValoration.rating = comment.valoration.toFloat()
        holder.itemDescription.text = comment.description
        holder.itemDate.text = comment.date
    }

    override fun getItemCount() = comments.size

    fun setComments(newComments: List<CommentsData>) {
        comments = newComments
        notifyDataSetChanged()
    }

}