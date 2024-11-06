package com.example.bogobici.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.bogobici.R
import com.google.firebase.auth.FirebaseAuth

class LogIn : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val logUpButton = view.findViewById<Button>(R.id.registrarse_bton)
        val forgetPasswordButton = view.findViewById<Button>(R.id.forget_password_bton)

        logUpButton.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                findNavController().navigate(R.id.action_logIn_to_signUp)
            }
        }

        forgetPasswordButton.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, ForgetPassword())
                addToBackStack(null)
            }
        }

        val logInButton = view.findViewById<Button>(R.id.log_in_bton)

        logInButton.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, BottomNavigationViewFragment())
                addToBackStack(null)
            }
        }

    }
}

