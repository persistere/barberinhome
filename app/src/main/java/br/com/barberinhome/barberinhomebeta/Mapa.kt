package br.com.barberinhome.barberinhomebeta

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.Circle



class Mapa : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val interlagos = LatLng(-23.687283, -46.692542)
        mMap.addMarker(MarkerOptions().position(interlagos).title("Interlagos"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(interlagos))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(interlagos, 13.0f))

        val circleOptions = CircleOptions()
                .center(interlagos)
                //.strokeColor(Color.BLUE)
                //.fillColor(Color.BLUE)
                .radius(1000.0) // In meters

        mMap.addCircle(circleOptions)


    }
}
