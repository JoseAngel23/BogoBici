package com.example.bogobici.ui.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bogobici.R
import com.google.firebase.auth.FirebaseAuth

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
        firebaseAuth = FirebaseAuth.getInstance()

        val registerButton = view.findViewById<Button>(R.id.register_bton)

        registerButton.setOnClickListener {
            val email = view.findViewById<EditText>(R.id.email_text).text.toString()
            val password = view.findViewById<EditText>(R.id.editTextTextPassword).text.toString()
            val confirmpassword = view.findViewById<EditText>(R.id.RetypePassword).text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmpassword.isNotEmpty()) {
                //if (password.equals(confirmpassword)) {
                    //firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        //if (it.isSuccessful) {
                            Toast.makeText(requireContext(), "Registro exitoso", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_signUp_to_upload_photo)
                        //} else {
                            Toast.makeText(requireContext(), "Error en el registro", Toast.LENGTH_SHORT).show()
                        //}
                    //}
                //} else {
                    //Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                //}
            //} else {
                //Toast.makeText(requireContext(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            //}
        }

        val backButton = view.findViewById<Button>(R.id.back_login_button)
        backButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            }
        }
    }
}