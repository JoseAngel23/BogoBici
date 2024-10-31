package com.example.bogobici

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bogobici.databinding.CommentsItemBinding
import android.widget.TextView

class AdapterComments(val comments: List<String>) : RecyclerView.Adapter<AdapterComments.ViewHolder>() {

    // Define el ViewHolder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1) // Usa un TextView simple
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) // Usando un layout simple
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = comments[position].toString() // Enlaza los datos
    }

    override fun getItemCount() = comments.size // Devuelve el tamaño de la lista

}