package com.example.testegooglemaps

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    internal var listofPoints = ArrayList<LatLng>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Barretos, Brazil.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Barretos and move the camera
        val zoomLevel = 15f

        setLatLong()
        addPolylines()

        val barretos = LatLng(-20.5541, -48.5698)
        mMap.addMarker(MarkerOptions().position(barretos).title("Marker in Barretos/SP").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(barretos, zoomLevel))
    }

    fun setLatLong()
    {
        listofPoints.add(LatLng(-20.5548683,-48.5746531))
        listofPoints.add(LatLng(-20.5568718,-48.5758461))
        listofPoints.add(LatLng(-20.559052,-48.5815836))
        listofPoints.add(LatLng(-20.5744211,-48.5623675))
    }

    fun addPolylines()
    {
        val polylineOptions = PolylineOptions()
        polylineOptions.addAll(listofPoints)
        polylineOptions.width(10f).color(Color.YELLOW)
        mMap.addPolyline(polylineOptions)
    }

}