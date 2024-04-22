package com.example.mapslocation

import AttractionsAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AttractionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attractions)

        val buildings = listOf("Casa Loma\n1 Austin Terrace, Toronto", "Little Canada\n10 Dundas St E Basement2, Toronto", "CN Tower\n290 Bremner Blvd, Toronto")
        val adapter = AttractionsAdapter(buildings) { buildingName ->
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("buildingName", buildingName)
            startActivity(intent)
        }
        val recyclerView: RecyclerView = findViewById(R.id.attraction_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, AttractionsActivity::class.java)
        }
    }
}