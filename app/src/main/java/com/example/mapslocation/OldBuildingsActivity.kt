package com.example.mapslocation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OldBuildingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old_buildings)


        val buildings = listOf("John Daniels House\n77 Yorkville Ave, Toronto",
            "John Irwin House\n21 Grenville St, Toronto", "George Brown House\n186 Beverley St, Toronto")
        val adapter = OldBuildingsAdapter(buildings) { buildingName ->
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("buildingName", buildingName)
            startActivity(intent)
        }
        val recyclerView: RecyclerView = findViewById(R.id.oldBuilding_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, OldBuildingsActivity::class.java)
        }
    }
}