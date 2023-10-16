package com.cibertec.cibertecapp.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.cibertec.cibertecapp.R
import java.lang.StringBuilder

class SensoresActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensores)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        getSensorList()
    }

    fun getSensorList() {
        val deviceSensors: List<Sensor> =
            sensorManager.getSensorList(Sensor.TYPE_ALL)

        val sensorText = StringBuilder()
        for (currentSensor in deviceSensors) {
            sensorText.append(currentSensor.name).append(
                System.getProperty("line.separator")
            )
        }

        val sensorTextView = findViewById<TextView>(R.id.textSensores) as TextView
        sensorTextView.text = sensorText
    }
}