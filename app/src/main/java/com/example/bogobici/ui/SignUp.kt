package com.example.bogobici.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.bogobici.R
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val signUpButton = view.findViewById<Button>(R.id.register_bton)
        val email = view.findViewById<EditText>(R.id.email_text)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword)
        val confirmpassword = view.findViewById<EditText>(R.id.RetypePassword)
        val backButton = view.findViewById<ImageButton>(R.id.back_button_sign_up)

        backButton?.setOnClickListener {
            requireActivity().supportFragmentManager.commit{
                findNavController().popBackStack()
            }
        }

        firebaseAuth = FirebaseAuth.getInstance()

        signUpButton?.setOnClickListener {

            val emailText = email?.text?.toString() ?: ""
            val passwordText = password?.text?.toString() ?: ""
            val confirmPasswordText = confirmpassword?.text?.toString() ?: ""

            if (emailText.isNotEmpty() && passwordText.isNotEmpty() && confirmPasswordText.isNotEmpty()) {
                if (passwordText == confirmPasswordText) {
                    firebaseAuth.createUserWithEmailAndPassword(emailText, passwordText)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                            Toast.makeText(requireContext(), "Registro exitoso", Toast.LENGTH_SHORT).show()
                            requireActivity().supportFragmentManager.commit{
                                findNavController().navigate(R.id.action_signUp_to_upload_photo)
                            }
                        } else {
                            Toast.makeText(requireContext(), "Error en el registro", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }


    }

}
