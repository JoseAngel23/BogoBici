package com.example.bogobici

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.firebase.firestore.FirebaseFirestore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RatingBar
import android.widget.Toast
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.firebase.firestore.toObject
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

class Comments : Fragment() {

    private lateinit var barChart: BarChart
    private lateinit var myAdapter: AdapterComments
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comments, container, false)

        val horizontalBarChart: HorizontalBarChart = view.findViewById(R.id.barChart)

        setupBarChart(horizontalBarChart)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        myAdapter = AdapterComments(emptyList())
        recyclerView.adapter = myAdapter
        getComments()

        val btnAddComment = view.findViewById<ImageButton>(R.id.imageButton)

        btnAddComment.setOnClickListener {
            mostrarModalComentarioYValoracion()
        }

        return view
    }

    private fun setupBarChart(horizontalBarChart: HorizontalBarChart) {
        val entries = ArrayList<BarEntry>()
        val valoraciones = arrayOf(10, 25, 40, 30, 15)
        for (i in valoraciones.indices) {
            entries.add(BarEntry(i.toFloat(), valoraciones[i].toFloat()))
        }

        val barDataSet = BarDataSet(entries, "Valoraciones")

        barDataSet.color = Color.parseColor("#107900")

        val barData = BarData(barDataSet)

        horizontalBarChart.data = barData
        horizontalBarChart.invalidate()

        horizontalBarChart.setDrawGridBackground(false)
        horizontalBarChart.setDrawBorders(false)
        horizontalBarChart.axisLeft.setDrawGridLines(false)
        horizontalBarChart.axisRight.setDrawGridLines(false)
        horizontalBarChart.xAxis.setDrawGridLines(false)

        horizontalBarChart.axisLeft.setDrawLabels(false)
        horizontalBarChart.axisRight.setDrawLabels(false)

        horizontalBarChart.description.isEnabled = false
        horizontalBarChart.legend.isEnabled = false

        horizontalBarChart.setTouchEnabled(false)
        horizontalBarChart.setDragEnabled(false)
        horizontalBarChart.setScaleEnabled(false)

        horizontalBarChart.xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return when (value.toInt()) {
                    0 -> "1"
                    1 -> "2"
                    2 -> "3"
                    3 -> "4"
                    4 -> "5"
                    else -> ""
                }
            }
        }
        horizontalBarChart.xAxis.position = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM
        horizontalBarChart.xAxis.granularity = 1f
        horizontalBarChart.xAxis.setAvoidFirstLastClipping(true)
    }

    private fun getComments() {
        db.collection("comments")
            .get()
            .addOnSuccessListener { result ->
                val comments = result.mapNotNull { it.toObject<CommentsData>() }
                println(comments)
                myAdapter.setComments(comments)
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }

    fun mostrarModalComentarioYValoracion() {
        val bottomSheetView = layoutInflater.inflate(R.layout.modal_add_comment, null)

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)

        val commentEditText = bottomSheetView.findViewById<EditText>(R.id.commentEditText)
        val ratingBar = bottomSheetView.findViewById<RatingBar>(R.id.ratingBar)
        val submitButton = bottomSheetView.findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val comentario = commentEditText.text.toString()
            val valoracion = ratingBar.rating

            if (comentario.isNotBlank() && valoracion > 0) {

                enviarComentarioYValoracion(comentario, valoracion)
                bottomSheetDialog.dismiss()
            } else {
                Toast.makeText(requireContext(), "Por favor, completa el comentario y la valoración", Toast.LENGTH_SHORT).show()
            }
        }
        bottomSheetDialog.show()
    }

    fun enviarComentarioYValoracion(comentario: String, valoracion: Float) {
        db.collection("comments").document().set(
            hashMapOf("name" to "Julian Ruge",
                "description" to comentario,
                "valoration" to valoracion,
                "date" to obtenerFechaActual(),
                "urlImage" to "https://img.freepik.com/foto-gratis/hombre-brazos-cruzados-sobre-fondo-blanco_1368-4445.jpg?t=st=1730872428~exp=1730876028~hmac=e6993b67c97b588460b057506bb014ec723962a77342fe201c7abd272ea191e0&w=740")
        )
    }

    fun obtenerFechaActual(): String {
        val calendar = Calendar.getInstance()
        val dia = calendar.get(Calendar.DAY_OF_MONTH)
        val mes = calendar.get(Calendar.MONTH) + 1
        val año = calendar.get(Calendar.YEAR)

        return String.format("%02d/%02d/%d", dia, mes, año)
    }



}