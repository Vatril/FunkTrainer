package com.vatril.funktrainer

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.vatril.funktrainer.adapter.RadioListAdapter

class AlphabetView(context: Context,attrs: AttributeSet?) : LinearLayout(context, attrs) {

    constructor(context: Context) : this(context, null)

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.alphabet_screen, this, true)
        findViewById<RecyclerView>(R.id.radiocharlist).adapter =
            RadioListAdapter(context)
        findViewById<RecyclerView>(R.id.radiocharlist).layoutManager = LinearLayoutManager(context)
    }

}