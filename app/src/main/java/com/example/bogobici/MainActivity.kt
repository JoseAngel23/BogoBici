package com.example.bogobici

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.nav_host_fragment, LogIn())
        }

        val textView3 = findViewById<TextView>(R.id.textView3)
        val text = "BogoBici"

        val spannable = SpannableString(text)

        val rojo = ForegroundColorSpan(Color.parseColor("#107900"))
        spannable.setSpan(rojo, 0, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        val azul = ForegroundColorSpan(Color.parseColor("#FFFFFF"))
        spannable.setSpan(azul, 5, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView3.text = spannable
    }
}