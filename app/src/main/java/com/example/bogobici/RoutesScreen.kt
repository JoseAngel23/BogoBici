package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bogobici.databinding.FragmentRoutesScreenBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class RoutesScreen : Fragment(R.layout.fragment_routes_screen) {

    private lateinit var binding: FragmentRoutesScreenBinding
    private lateinit var myAdapter: AdapterRoutes
    //private lateinit var adapterCarousel: AdapterCarousel
    private val db = FirebaseFirestore.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRoutesScreenBinding.bind(view)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_routes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        myAdapter = AdapterRoutes(emptyList())
        recyclerView.adapter = myAdapter

        //val recyclerViewCarousel = view.findViewById<RecyclerView>(R.id.img_route)
        //recyclerViewCarousel.layoutManager = LinearLayoutManager(requireContext())

        //adapterCarousel = AdapterCarousel(emptyList())
        //recyclerViewCarousel.adapter = adapterCarousel

        getRoutes()
        //getImagesCarousel()

    }

    private fun getRoutes() {
        db.collection("routes")
            .get()
            .addOnSuccessListener { result ->
                val routes = result.mapNotNull { it.toObject<RoutesData>() }
                println(routes)
                myAdapter.setRoutes(routes)
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }
    /*
    private fun getImagesCarousel() {
        db.collection("routes")
            .get()
            .addOnSuccessListener { result ->
                val carousel = result.mapNotNull { it.toObject<CarouselData>() }
                adapterCarousel.setImages(carousel)

            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }
    */
}