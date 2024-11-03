package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bogobici.adapters.ImageAdapter
import models.ImageItem
import java.util.UUID

class RoutesScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_routes_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageRV = view.findViewById<RecyclerView>(R.id.imageRV)

        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "home/joseforeroangel/Descargas/blue.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "home/joseforeroangel/Descargas/yellow.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "home/joseforeroangel/Descargas/orange.jpg"
            ),
        )

        val imageAdapter = ImageAdapter()

        imageRV.adapter = imageAdapter

        imageAdapter.submitList(imageList)

    }
}