package com.cibertec.cibertecapp.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cibertec.cibertecapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StepCounterActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_counter)

        val fabStart = findViewById<FloatingActionButton>(R.id.fabStart)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) == null) {
            fabStart.visibility = View.GONE
        }

        fabStart.setOnClickListener {
            sensor?.also {
                sensorManager.registerListener(this, it,
                    SensorManager.SENSOR_DELAY_FASTEST)
            }
        }

    }

    override fun onSensorChanged(p0: SensorEvent?) {

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}