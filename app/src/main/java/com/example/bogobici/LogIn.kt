package com.example.bogobici

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class LogIn : Fragment() {

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
                replace(R.id.nav_host_fragment, SignUp())
                addToBackStack(null)
            }
        }

        forgetPasswordButton.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.nav_host_fragment, ForgetPassword())
                addToBackStack(null)
            }
        }

        val loginButton = view.findViewById<Button>(R.id.back_login_button)
    }
}

