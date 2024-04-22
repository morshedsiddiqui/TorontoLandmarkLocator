package com.example.mapslocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mapslocation.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var buildingName: String
    private lateinit var mapsHelper: MapsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        buildingName = intent.getStringExtra("buildingName") ?: ""
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mapsHelper = MapsHelper(mMap)

        val location = when (buildingName) {
            "John Daniels House\n77 Yorkville Ave, Toronto" -> LatLng(43.6718889525566, -79.38910351947025)
            "John Irwin House\n21 Grenville St, Toronto" -> LatLng(43.662760075104394, -79.38369733335742)
            "George Brown House\n186 Beverley St, Toronto" -> LatLng(43.65717216856634, -79.39125188994481)
            "TD Gallery\n789 Yonge St Main Floor, Toronto" -> LatLng(43.67328658836211, -79.38360591919698)
            "Museum of Illusions Toronto\n132 Front St E, Toronto" -> LatLng(43.650931026781365, -79.3690333002851)
            "Royal Ontario Museum\n100 Queens Park, Toronto" -> LatLng(43.668162003057326, -79.39466736018579)
            "Rogers Centre\n1 Blue Jays Way, Toronto" -> LatLng(43.64246754143032, -79.38631581052799)
            "Scotiabank Arena\n40 Bay St., Toronto" -> LatLng(43.64444955315324, -79.37618527443566)
            "BMO Field\n170 Princes' Blvd, Toronto" -> LatLng(43.63403149810219, -79.41429850395893)
            "Casa Loma\n1 Austin Terrace, Toronto" -> LatLng(43.679057058936074, -79.40411603974606)
            "Little Canada\n10 Dundas St E Basement2, Toronto" -> LatLng(43.65757671122106, -79.37853910463545)
            "CN Tower\n290 Bremner Blvd, Toronto" -> LatLng(43.64360086347192, -79.38652203169096)
            else -> LatLng(0.0, 0.0)
        }
        mMap.addMarker(MarkerOptions().position(location).title(buildingName))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        mapsHelper.zoomToLocation(location, 15f)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.maptype, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mapNormal -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.mapHybrid -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
        }
        return super.onOptionsItemSelected(item)
    }
    class MapsHelper(private val map: GoogleMap) {

        fun zoomToLocation(location: LatLng, zoomLevel: Float) {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(location, zoomLevel))
        }
    }
}
// What should be the output with the default code..
// Displaying the location of City of Sydney, Australia
