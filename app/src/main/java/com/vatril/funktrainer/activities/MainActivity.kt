package com.vatril.funktrainer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.vatril.funktrainer.R
import com.vatril.funktrainer.fragment.AlphabetFragment
import com.vatril.funktrainer.fragment.TrainingFragment
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var alphabet = AlphabetFragment()
        var training = TrainingFragment()
        var fragment:Fragment = alphabet


        supportFragmentManager.beginTransaction()
            .replace(R.id.main_holder, fragment).commit()


        main_nav.setNavigationItemSelectedListener {
            main_holder.removeAllViews()
            when (it.itemId) {
                R.id.nav_alphabet -> fragment = alphabet
                R.id.nav_training_random -> fragment = training
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_holder, fragment).commit()
            main_drawer.closeDrawers()
            true
        }

    }
}
