package com.example.mapproject

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mapproject.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.Locale


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    var address : String = ""
    var Latitude: Double = 0.0
    var Longitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        binding.btnSearch.setOnClickListener {
            mMap = googleMap

            Latitude = binding.edtLatitude.text.toString().toDouble()
            Longitude = binding.edtLongitude.text.toString().toDouble()

            // Add a marker in Sydney and move the camera
            val sydney = LatLng(Latitude, Longitude)

            val geocoder: Geocoder = Geocoder(this, Locale.getDefault())

            val addresses: List<Address>? = geocoder.getFromLocation(Latitude, Longitude, 1)


             address =
                addresses!![0].getAddressLine(0)

            val city = addresses!![0].locality
            val state = addresses!![0].adminArea
            val country = addresses!![0].countryName
            val postalCode = addresses!![0].postalCode
            val knownName = addresses!![0].featureName

            mMap.addMarker(MarkerOptions().position(sydney).title(address))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

            val zoomLevel = 18.0.toFloat()
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel))
        }
    }
}