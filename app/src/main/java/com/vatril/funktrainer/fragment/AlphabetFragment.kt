package com.vatril.funktrainer.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.vatril.funktrainer.R
import com.vatril.funktrainer.adapter.RadioListAdapter
import kotlinx.android.synthetic.main.alphabet_screen.view.*

class AlphabetFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.alphabet_screen, null)
        view.radiocharlist.adapter = RadioListAdapter(view.context)
        view.radiocharlist.layoutManager = LinearLayoutManager(view.context)
        return view
    }

}