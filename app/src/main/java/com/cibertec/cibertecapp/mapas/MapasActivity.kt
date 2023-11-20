package com.cibertec.cibertecapp.mapas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cibertec.cibertecapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapasActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map : GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapas)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap)
                as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {

        map = p0
        map.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(this, R.raw.style_json)
        )

        val positionMarker = LatLng(-8.1116778,-79.0287742)
        map.addMarker(
            MarkerOptions()
                .position(positionMarker)
                .title("Ciudad de Trujillo")
        )

        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(positionMarker, 18f),
            4000, null
        )

    }
}