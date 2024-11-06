package com.example.bogobici

import android.os.Bundle
import android.util.Log
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
    private val db = FirebaseFirestore.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRoutesScreenBinding.bind(view)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_routes)

        getRoutes(recyclerView)

    }

    private fun getRoutes(recyclerView: RecyclerView) {
        val firestore = FirebaseFirestore.getInstance()
        firestore.collection("routes")
            .get()
            .addOnSuccessListener { result ->
                val items = result.documents.map { document ->
                    RoutesData(
                        name = document.getString("name") ?: "",
                        images = document.get("images") as? List<String> ?: emptyList()
                    )
                }

                val mainAdapter = AdapterRoutes(items)
                recyclerView.adapter = mainAdapter
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore", "Error retrieving data", exception)
            }
    }
}