package com.example.bogobici.ui.Auth

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
import androidx.fragment.app.viewModels
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import com.example.bogobici.R
import com.example.bogobici.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp : Fragment() {

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
        val emailEditText = view.findViewById<EditText>(R.id.email_text)
        val passwordEditText = view.findViewById<EditText>(R.id.editTextTextPassword)
        val backButton = view.findViewById<ImageButton>(R.id.back_button_sign_up)

        signUpButton.setOnClickListener {
            requireActivity().supportFragmentManager.commit{
                findNavController().navigate(R.id.action_signUp_to_upload_photo)
            }
        }

        backButton.setOnClickListener {
            requireActivity().supportFragmentManager.commit{
                findNavController().popBackStack()
            }
        }


    }

}