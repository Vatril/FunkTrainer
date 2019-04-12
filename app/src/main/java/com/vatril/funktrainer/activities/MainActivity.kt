package com.vatril.funktrainer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.vatril.funktrainer.R
import com.vatril.funktrainer.adapter.RadioListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawer = findViewById<DrawerLayout>(R.id.main_drawer)


        findViewById<NavigationView>(R.id.main_nav).setNavigationItemSelectedListener {
            Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
            drawer.closeDrawers()
            true
        }

    }
}
