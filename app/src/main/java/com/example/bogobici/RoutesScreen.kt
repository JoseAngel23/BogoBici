package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.bogobici.databinding.FragmentRoutesScreenBinding

class RoutesScreen : Fragment(R.layout.fragment_routes_screen) {

    private lateinit var binding: FragmentRoutesScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRoutesScreenBinding.bind(view)


    }
}