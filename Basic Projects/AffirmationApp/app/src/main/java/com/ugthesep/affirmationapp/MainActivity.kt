package com.ugthesep.affirmationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.ugthesep.affirmationapp.adapter.ItemAdapter
import com.ugthesep.affirmationapp.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadAffirmation()
        val recycleView = findViewById<RecyclerView>(R.id.recycler_view)
        recycleView.adapter = ItemAdapter(this,myDataset)
        recycleView.setHasFixedSize(true)

    }
}