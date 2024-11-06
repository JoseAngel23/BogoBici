package com.example.bogobici

import android.widget.ImageView
import androidx.collection.IntList
import com.github.mikephil.charting.components.Description

data class CommentsData (
    val name: String = "",
    val description: String = "",
    val valoration: Int = 1,
    val date: String = "",
    val urlImage: String = ""
)