package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController


class EditProfile : Fragment(R.layout.fragment_edit_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bntNotification = view.findViewById<ImageButton>(R.id.imageNotification)

        bntNotification.setOnClickListener{
            requireActivity().supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, Notification())
                addToBackStack(null)
            }
        }
    }
}