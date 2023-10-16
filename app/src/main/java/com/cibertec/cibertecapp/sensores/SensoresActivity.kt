package com.cibertec.cibertecapp.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.cibertec.cibertecapp.R
import java.lang.StringBuilder

class SensoresActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var mLight: Sensor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensores)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        mLight?.also {
            sensorManager.registerListener(this, it,
                SensorManager.SENSOR_DELAY_NORMAL)
        }

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

    // Proporcionar un objecto con los datos tomados por el sensor
    override fun onSensorChanged(p0: SensorEvent?) {

    }

    // Proporciona información sensor y su presición
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}