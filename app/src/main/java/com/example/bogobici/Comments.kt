package com.example.bogobici

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
import com.github.mikephil.charting.utils.ColorTemplate

class Comments : Fragment() {

    private lateinit var barChart: BarChart
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: AdapterComments

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comments, container, false)
        barChart = view.findViewById(R.id.barChart)
        recyclerView = view.findViewById(R.id.recyclerView)
        setupBarChart()
        setupRecyclerView()
        return view
    }

    private fun setupBarChart() {
        val ratings = intArrayOf(10, 15, 30, 25, 20) // Cantidad de personas que calificaron del 1 al 5

        val entries = ArrayList<BarEntry>()
        for (i in ratings.indices) {
            entries.add(BarEntry((i + 1).toFloat(), ratings[i].toFloat())) // i + 1 para calificación del 1 al 5
        }

        val dataSet = BarDataSet(entries, "Calificaciones")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList() // Asigna colores
        val barData = BarData(dataSet)
        barChart.data = barData
        barChart.setFitBars(true)
        barChart.invalidate() // Refresca el gráfico
    }

    private fun setupRecyclerView() {
        // Datos de ejemplo
        val items: List<String> = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        myAdapter = AdapterComments(items)
        recyclerView.layoutManager = LinearLayoutManager(context) // Usa LinearLayoutManager
        recyclerView.adapter = myAdapter // Asigna el adaptador al RecyclerView
    }
}