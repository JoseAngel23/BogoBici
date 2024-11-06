package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth

class HomeScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logout = view.findViewById<ImageButton>(R.id.imageButton4)
        val correoPantalla = view.findViewById<TextView>(R.id.correo_pantalla)

        // Obtén el correo del usuario actual y muéstralo en el TextView
        val currentUser = FirebaseAuth.getInstance().currentUser
        correoPantalla.text = currentUser?.email ?: "Correo no disponible"

        // Configura el botón de logout si es necesario
        logout.setOnClickListener {
            // Lógica para cerrar sesión o redireccionar
            FirebaseAuth.getInstance().signOut()
            findNavController().navigate(R.id.action_homeScreen_to_logIn)
        }
    }
}
