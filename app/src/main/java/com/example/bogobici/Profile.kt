package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.commit

class Profile : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notifications = view.findViewById<ImageButton>(R.id.notificacions)
        val settings = view.findViewById<ImageButton>(R.id.settings_bton)

        notifications.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, Notification())
                addToBackStack(null)
            }
        }

        settings.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, EditProfile())
                addToBackStack(null)
            }
        }
    }
}