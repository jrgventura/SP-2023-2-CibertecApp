package com.cibertec.cibertecapp.sensores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cibertec.cibertecapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StepHistorialCounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_historial_counter)

        val fabCounter = findViewById<FloatingActionButton>(R.id.fabCounter)
        fabCounter.setOnClickListener {
            startActivity(Intent(this,
                StepCounterActivity::class.java))
        }

    }
}