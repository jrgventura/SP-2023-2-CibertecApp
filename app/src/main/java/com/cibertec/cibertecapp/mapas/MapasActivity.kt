package com.cibertec.cibertecapp.mapas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cibertec.cibertecapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment

class MapasActivity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapas)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap)
                as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {

    }
}