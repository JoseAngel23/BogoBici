package com.example.bogobici

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import android.app.Activity
import android.widget.*
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.bogobici.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.io.ByteArrayOutputStream
import java.util.*



class Upload_photo : Fragment() {

    var pickedPhoto : Uri? = null
    var pickedBitMap : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_upload_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = view.findViewById<ImageView>(R.id.photoSelect)
        val nextButton = view.findViewById<Button>(R.id.upload_bton)

        imageView.setOnClickListener {
            pickPhoto(it)
        }

        nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_upload_photo_to_before_sports)
        }

    }

    fun pickPhoto(view: View) {
        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE) // Use requireContext()
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), // Use requireActivity()
                1)
        } else {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 2)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val galeriIntext = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntext, 2)
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            pickedPhoto = data.data
            if (pickedPhoto != null) {
                val imageView = view?.findViewById<ImageView>(R.id.photoSelect) // Find the ImageView
                if (Build.VERSION.SDK_INT >= 28) {
                    val source = ImageDecoder.createSource(requireActivity().contentResolver, pickedPhoto!!) // Use requireActivity().contentResolver
                    pickedBitMap = ImageDecoder.decodeBitmap(source)
                    imageView?.setImageBitmap(pickedBitMap) // Set bitmap on ImageView
                } else {
                    pickedBitMap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, pickedPhoto) // Use requireActivity().contentResolver
                    imageView?.setImageBitmap(pickedBitMap) // Set bitmap on ImageView
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}