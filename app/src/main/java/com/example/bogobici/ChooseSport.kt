package com.example.bogobici

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

class ChooseSport : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_sport, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val finishButton = view.findViewById<Button>(R.id.finish_bton)
        val addButtonOne = view.findViewById<ImageView>(R.id.icon_one)
        val addButtonTwo = view.findViewById<ImageView>(R.id.imageView4)
        val addButtonThree = view.findViewById<ImageView>(R.id.imageView5)
        val addButtonFour = view.findViewById<ImageView>(R.id.imageView6)
        val addButtonFive = view.findViewById<ImageView>(R.id.imageView7)


        finishButton.setOnClickListener {
            findNavController().navigate(R.id.action_chooseSport_to_bottomNavigationViewFragment)
        }

        addButtonOne.setOnClickListener {
            addButtonOne.setImageResource(R.drawable.check_circle_26dp_006b59_fill0_wght400_grad0_opsz24)
        }

        addButtonTwo.setOnClickListener {
            addButtonTwo.setImageResource(R.drawable.check_circle_26dp_006b59_fill0_wght400_grad0_opsz24)
        }

        addButtonThree.setOnClickListener {
            addButtonThree.setImageResource(R.drawable.check_circle_26dp_006b59_fill0_wght400_grad0_opsz24)
        }

        addButtonFour.setOnClickListener {
            addButtonFour.setImageResource(R.drawable.check_circle_26dp_006b59_fill0_wght400_grad0_opsz24)
        }

        addButtonFive.setOnClickListener {
            addButtonFive.setImageResource(R.drawable.check_circle_26dp_006b59_fill0_wght400_grad0_opsz24)
        }

    }

}