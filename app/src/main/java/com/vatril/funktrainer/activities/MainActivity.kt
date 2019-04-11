package com.vatril.funktrainer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.vatril.funktrainer.R
import com.vatril.funktrainer.adapter.RadioListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //findViewById<RecyclerView>(R.id.radiocharlist).adapter =
        //    RadioListAdapter(this)
        //findViewById<RecyclerView>(R.id.radiocharlist).layoutManager = LinearLayoutManager(this)
    }
}
