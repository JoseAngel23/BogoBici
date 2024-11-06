package com.example.bogobici

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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
        val logInButton = view.findViewById<Button>(R.id.log_in_bton)
        val emailEditText = view.findViewById<EditText>(R.id.user_text)
        val passwordEditText = view.findViewById<EditText>(R.id.password_text)

        firebaseAuth = FirebaseAuth.getInstance()

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

        logInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(requireContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                            requireActivity().supportFragmentManager.commit {
                                replace(R.id.nav_host_fragment, BottomNavigationViewFragment())
                                addToBackStack(null)
                            }
                        } else {
                            val errorMessage = task.exception?.message ?: "Error en el inicio de sesión"
                            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

