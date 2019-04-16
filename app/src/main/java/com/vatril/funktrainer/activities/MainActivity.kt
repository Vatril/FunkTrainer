package com.vatril.funktrainer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vatril.funktrainer.R
import com.vatril.funktrainer.view.AlphabetView
import com.vatril.funktrainer.view.TrainingView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        main_nav.setNavigationItemSelectedListener {
            main_holder.removeAllViews()
            when (it.itemId) {
                R.id.nav_alphabet -> main_holder.addView(AlphabetView(this))
                R.id.nav_training_random -> main_holder.addView(TrainingView(this, true))
            }
            main_drawer.closeDrawers()
            true
        }

    }
}
