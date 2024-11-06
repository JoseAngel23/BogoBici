package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class Notification : Fragment() {

    private lateinit var myAdapter: AdapterNotification
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerNotification)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        myAdapter = AdapterNotification(emptyList())
        recyclerView.adapter = myAdapter

        getNotifications()

        return view
    }

    private fun getNotifications() {
        db.collection("notifications")
            .get()
            .addOnSuccessListener { result ->
                val notifications = result.mapNotNull { it.toObject<NotificationData>() }
                println(notifications)
                myAdapter.setNotification(notifications)
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }

}