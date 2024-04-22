package com.example.mapslocation

import StadiumsAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StadiumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stadiums)

        val buildings = listOf("Rogers Centre\n1 Blue Jays Way, Toronto", "Scotiabank Arena" +
                "\n40 Bay St., Toronto", "BMO Field\n170 Princes' Blvd, Toronto")
        val adapter = StadiumsAdapter(buildings) { buildingName ->
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("buildingName", buildingName)
            startActivity(intent)
        }
        val recyclerView: RecyclerView = findViewById(R.id.stadium_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, StadiumsActivity::class.java)
        }
    }
}