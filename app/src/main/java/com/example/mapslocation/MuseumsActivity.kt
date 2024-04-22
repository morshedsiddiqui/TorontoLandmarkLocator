package com.example.mapslocation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MuseumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museums)

        val buildings = listOf("TD Gallery\n789 Yonge St Main Floor, Toronto", "Museum of Illusions Toronto\n132 Front St E, Toronto", "Royal Ontario Museum\n100 Queens Park, Toronto")
        val adapter = MuseumsAdapter(buildings) { buildingName ->
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("buildingName", buildingName)
            startActivity(intent)
        }
        val recyclerView: RecyclerView = findViewById(R.id.museum_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MuseumsActivity::class.java)
        }
    }
}